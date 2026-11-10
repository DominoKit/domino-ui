/*
 * Copyright © 2026 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerVersionControl;

/** Static icon factory for the Tabler Version Control category. */
public final class TablerVersionControl_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerVersionControl tagIcons = new TablerVersionControl() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "git-branch (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH)",
            tagIcons::git_branch));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-check (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_CHECK)",
            tagIcons::git_branch_check));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-deleted (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_DELETED)",
            tagIcons::git_branch_deleted));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-x (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_X)",
            tagIcons::git_branch_x));
    icons.add(
        new IconCatalogEntry<>(
            "git-cherry-pick (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_CHERRY_PICK)",
            tagIcons::git_cherry_pick));
    icons.add(
        new IconCatalogEntry<>(
            "git-commit (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_COMMIT)",
            tagIcons::git_commit));
    icons.add(
        new IconCatalogEntry<>(
            "git-compare (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_COMPARE)",
            tagIcons::git_compare));
    icons.add(
        new IconCatalogEntry<>(
            "git-fork (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_FORK)",
            tagIcons::git_fork));
    icons.add(
        new IconCatalogEntry<>(
            "git-merge (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_MERGE)",
            tagIcons::git_merge));
    icons.add(
        new IconCatalogEntry<>(
            "git-merge-queue (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_MERGE_QUEUE)",
            tagIcons::git_merge_queue));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST)",
            tagIcons::git_pull_request));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-closed (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_CLOSED)",
            tagIcons::git_pull_request_closed));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-conflict (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_CONFLICT)",
            tagIcons::git_pull_request_conflict));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-draft (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_DRAFT)",
            tagIcons::git_pull_request_draft));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-locked (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_LOCKED)",
            tagIcons::git_pull_request_locked));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-unlisted (outline)",
            "TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_UNLISTED)",
            tagIcons::git_pull_request_unlisted));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
