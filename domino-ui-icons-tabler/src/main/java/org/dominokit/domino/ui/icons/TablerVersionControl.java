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
package org.dominokit.domino.ui.icons;

/** Tabler Version control catalog category. */
public interface TablerVersionControl {
  enum OutlineIcon implements TablerIconDefinition {
    GIT_BRANCH(
        "git-branch",
        "<path d=\"M5 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 8l0 8\" />\n  <path d=\"M9 18h6a2 2 0 0 0 2 -2v-5\" />\n  <path d=\"M14 14l3 -3l3 3\" />"),
    GIT_BRANCH_CHECK(
        "git-branch-check",
        "<path d=\"M5 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M15 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M7 12h8a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    GIT_BRANCH_DELETED(
        "git-branch-deleted",
        "<path d=\"M5 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M9 18h6a2 2 0 0 0 2 -2v-5\" />\n  <path d=\"M14 14l3 -3l3 3\" />\n  <path d=\"M15 4l4 4\" />\n  <path d=\"M15 8l4 -4\" />"),
    GIT_BRANCH_X(
        "git-branch-x",
        "<path d=\"M5 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M15 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M7 12h8a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    GIT_CHERRY_PICK(
        "git-cherry-pick",
        "<path d=\"M4 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M7 3v6\" />\n  <path d=\"M7 15v6\" />\n  <path d=\"M13 7h2.5l1.5 5l-1.5 5h-2.5\" />\n  <path d=\"M17 12h3\" />"),
    GIT_COMMIT(
        "git-commit",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 3l0 6\" />\n  <path d=\"M12 15l0 6\" />"),
    GIT_COMPARE(
        "git-compare",
        "<path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M11 6h5a2 2 0 0 1 2 2v8\" />\n  <path d=\"M14 9l-3 -3l3 -3\" />\n  <path d=\"M13 18h-5a2 2 0 0 1 -2 -2v-8\" />\n  <path d=\"M10 15l3 3l-3 3\" />"),
    GIT_FORK(
        "git-fork",
        "<path d=\"M10 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 8v2a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M12 12l0 4\" />"),
    GIT_MERGE(
        "git-merge",
        "<path d=\"M5 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 8l0 8\" />\n  <path d=\"M7 8a4 4 0 0 0 4 4h4\" />"),
    GIT_MERGE_QUEUE(
        "git-merge-queue",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M16 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 11v5\" />\n  <path d=\"M4.5 4.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9.5 9.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GIT_PULL_REQUEST(
        "git-pull-request",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 8l0 8\" />\n  <path d=\"M11 6h5a2 2 0 0 1 2 2v8\" />\n  <path d=\"M14 9l-3 -3l3 -3\" />"),
    GIT_PULL_REQUEST_CLOSED(
        "git-pull-request-closed",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 11v5\" />\n  <path d=\"M16 4l4 4m0 -4l-4 4\" />"),
    GIT_PULL_REQUEST_CONFLICT(
        "git-pull-request-conflict",
        "<path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M11 6h5a2 2 0 0 1 2 2v8\" />\n  <path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 11v5\" />\n  <path d=\"M4 4l4 4\" />\n  <path d=\"M8 4l-4 4\" />"),
    GIT_PULL_REQUEST_DRAFT(
        "git-pull-request-draft",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 11h.01\" />\n  <path d=\"M18 6h.01\" />"),
    GIT_PULL_REQUEST_LOCKED(
        "git-pull-request-locked",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M11 6h5a2 2 0 0 1 2 2v1\" />\n  <path d=\"M14 9l-3 -3l3 -3\" />\n  <path d=\"M14 17a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1v-3\" />\n  <path d=\"M16 16v-1.5a1.5 1.5 0 1 1 3 0v1.5\" />"),
    GIT_PULL_REQUEST_UNLISTED(
        "git-pull-request-unlisted",
        "<path d=\"M16.5 5.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16.5 11.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M4 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M16 17l3 3\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  enum FilledIcon implements TablerIconDefinition {
    ;

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "filled";
    }
  }

  default TablerIcon git_branch() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH);
  }

  default TablerIcon git_branch_check() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_CHECK);
  }

  default TablerIcon git_branch_deleted() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_DELETED);
  }

  default TablerIcon git_branch_x() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_BRANCH_X);
  }

  default TablerIcon git_cherry_pick() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_CHERRY_PICK);
  }

  default TablerIcon git_commit() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_COMMIT);
  }

  default TablerIcon git_compare() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_COMPARE);
  }

  default TablerIcon git_fork() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_FORK);
  }

  default TablerIcon git_merge() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_MERGE);
  }

  default TablerIcon git_merge_queue() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_MERGE_QUEUE);
  }

  default TablerIcon git_pull_request() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST);
  }

  default TablerIcon git_pull_request_closed() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_CLOSED);
  }

  default TablerIcon git_pull_request_conflict() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_CONFLICT);
  }

  default TablerIcon git_pull_request_draft() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_DRAFT);
  }

  default TablerIcon git_pull_request_locked() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_LOCKED);
  }

  default TablerIcon git_pull_request_unlisted() {
    return TablerIcon.create(TablerVersionControl.OutlineIcon.GIT_PULL_REQUEST_UNLISTED);
  }
}
