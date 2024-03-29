/*
 * @(#)IdentificationTable.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.ContextualAnalyzer;

import Triangle.AbstractSyntaxTrees.*;

public final class IdentificationTable {

  private int level;
  private IdEntry latest;

  public IdentificationTable () {
    level = 0;
    latest = null;
  }

  // Opens a new level in the identification table, 1 higher than the
  // current topmost level.

  public void openScope () {

    level ++;
  }

  // Closes the topmost level in the identification table, discarding
  // all entries belonging to that level.

  public void closeScope () {

    IdEntry entry, local, temp;

    // Presumably, idTable.level > 0.
    entry = this.latest;
    temp = this.latest;
    boolean scopeLocal = this.isLocal(entry);
    while (entry.level == this.level || scopeLocal) {
      local = entry;
      entry = local.previous;
      if (scopeLocal && !(entry.level == this.level)) {
        temp = entry;
        scopeLocal = this.isLocal(entry);
      } else {
        scopeLocal = false;
      }
    }
    this.level--;
    if (temp != entry) {
      temp.previous = entry;
    }
    while (this.latest.level > this.level) {
      this.latest = this.latest.previous;
    }
  }

  private boolean isLocal(IdEntry entry) {
    boolean found = false;
    while (entry.previous != null && this.level - entry.level <= 1) {
      if (entry.previous.level > entry.level || entry.id.equals("local")) {
        found = true;
        break;
      }
      entry = entry.previous;
    }
    return found;
  }


  // Makes a new entry in the identification table for the given identifier
  // and attribute. The new entry belongs to the current level.
  // duplicated is set to to true iff there is already an entry for the
  // same identifier at the current level.

  public void enter (String id, Declaration attr) {

    IdEntry entry = this.latest;
    int offset = 0;
    if (entry != null && (entry.level < this.level || entry.id.equals("local"))) {
      if (this.isLocal(this.latest)) {
        offset = 1;
      }
    }
    boolean present = false, searching = true;

    // Check for duplicate entry ...
    while (searching) {
      if (entry == null || entry.level - offset < this.level )
        searching = false;
      else if (entry.id.equals(id)) {
        present = true;
        searching = false;
       } else
       entry = entry.previous;
    }

    attr.duplicated = present;
    // Add new entry ...
    entry = new IdEntry(id, attr, this.level - offset, this.latest);
    this.latest = entry;
  }

  // Finds an entry for the given identifier in the identification table,
  // if any. If there are several entries for that identifier, finds the
  // entry at the highest level, in accordance with the scope rules.
  // Returns null iff no entry is found.
  // otherwise returns the attribute field of the entry found.

  public Declaration retrieve (String id) {

    IdEntry entry;
    Declaration attr = null;
    boolean present = false, searching = true;

    entry = this.latest;
    int level = this.level;
    while (searching) {
      if (entry == null)
        searching = false;
      else if (entry.id.equals(id) && (isSTD(entry) || level >= entry.level)) {
        present = true;
        searching = false;
        attr = entry.attr;
      } else
        entry = entry.previous;
    }

    return attr;
  }

  private boolean isSTD(IdEntry entry) {
    return entry.attr instanceof UnaryOperatorDeclaration
            || entry.attr instanceof BinaryOperatorDeclaration
            || entry.attr instanceof ProcDeclaration
            || entry.attr instanceof FuncDeclaration
            || entry.attr instanceof ConstDeclaration
            || entry.attr instanceof TypeDeclaration;
  }
}
