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
            "git-branch", "TablerIcons.git_branch()", tagIcons::git_branch));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-check",
            "TablerIcons.git_branch_check()",
            tagIcons::git_branch_check));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-deleted",
            "TablerIcons.git_branch_deleted()",
            tagIcons::git_branch_deleted));
    icons.add(
        new IconCatalogEntry<>(
            "git-branch-x", "TablerIcons.git_branch_x()", tagIcons::git_branch_x));
    icons.add(
        new IconCatalogEntry<>(
            "git-cherry-pick",
            "TablerIcons.git_cherry_pick()",
            tagIcons::git_cherry_pick));
    icons.add(
        new IconCatalogEntry<>(
            "git-commit", "TablerIcons.git_commit()", tagIcons::git_commit));
    icons.add(
        new IconCatalogEntry<>(
            "git-compare", "TablerIcons.git_compare()", tagIcons::git_compare));
    icons.add(
        new IconCatalogEntry<>("git-fork", "TablerIcons.git_fork()", tagIcons::git_fork));
    icons.add(
        new IconCatalogEntry<>(
            "git-merge", "TablerIcons.git_merge()", tagIcons::git_merge));
    icons.add(
        new IconCatalogEntry<>(
            "git-merge-queue",
            "TablerIcons.git_merge_queue()",
            tagIcons::git_merge_queue));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request",
            "TablerIcons.git_pull_request()",
            tagIcons::git_pull_request));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-closed",
            "TablerIcons.git_pull_request_closed()",
            tagIcons::git_pull_request_closed));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-conflict",
            "TablerIcons.git_pull_request_conflict()",
            tagIcons::git_pull_request_conflict));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-draft",
            "TablerIcons.git_pull_request_draft()",
            tagIcons::git_pull_request_draft));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-locked",
            "TablerIcons.git_pull_request_locked()",
            tagIcons::git_pull_request_locked));
    icons.add(
        new IconCatalogEntry<>(
            "git-pull-request-unlisted",
            "TablerIcons.git_pull_request_unlisted()",
            tagIcons::git_pull_request_unlisted));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
