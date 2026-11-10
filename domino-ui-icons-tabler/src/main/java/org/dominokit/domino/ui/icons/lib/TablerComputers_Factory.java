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
import org.dominokit.domino.ui.icons.TablerComputers;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Computers category. */
public final class TablerComputers_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerComputers tagIcons = new TablerComputers() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "binary (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.BINARY)",
            tagIcons::binary));
    icons.add(
        new IconCatalogEntry<>(
            "binary-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.BINARY_OFF)",
            tagIcons::binary_off));
    icons.add(
        new IconCatalogEntry<>(
            "binary-tree (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.BINARY_TREE)",
            tagIcons::binary_tree));
    icons.add(
        new IconCatalogEntry<>(
            "binary-tree-2 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.BINARY_TREE_2)",
            tagIcons::binary_tree_2));
    icons.add(
        new IconCatalogEntry<>(
            "cloud-computing (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.CLOUD_COMPUTING)",
            tagIcons::cloud_computing));
    icons.add(
        new IconCatalogEntry<>(
            "cloud-data-connection (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.CLOUD_DATA_CONNECTION)",
            tagIcons::cloud_data_connection));
    icons.add(
        new IconCatalogEntry<>(
            "error-404 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.ERROR_404)",
            tagIcons::error_404));
    icons.add(
        new IconCatalogEntry<>(
            "error-404-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.ERROR_404_OFF)",
            tagIcons::error_404_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-connect (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_CONNECT)",
            tagIcons::http_connect));
    icons.add(
        new IconCatalogEntry<>(
            "http-connect-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_CONNECT_OFF)",
            tagIcons::http_connect_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-delete (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_DELETE)",
            tagIcons::http_delete));
    icons.add(
        new IconCatalogEntry<>(
            "http-delete-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_DELETE_OFF)",
            tagIcons::http_delete_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-get (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_GET)",
            tagIcons::http_get));
    icons.add(
        new IconCatalogEntry<>(
            "http-get-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_GET_OFF)",
            tagIcons::http_get_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-head (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_HEAD)",
            tagIcons::http_head));
    icons.add(
        new IconCatalogEntry<>(
            "http-head-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_HEAD_OFF)",
            tagIcons::http_head_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-options (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_OPTIONS)",
            tagIcons::http_options));
    icons.add(
        new IconCatalogEntry<>(
            "http-options-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_OPTIONS_OFF)",
            tagIcons::http_options_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-patch (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PATCH)",
            tagIcons::http_patch));
    icons.add(
        new IconCatalogEntry<>(
            "http-patch-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PATCH_OFF)",
            tagIcons::http_patch_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-post (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_POST)",
            tagIcons::http_post));
    icons.add(
        new IconCatalogEntry<>(
            "http-post-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_POST_OFF)",
            tagIcons::http_post_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-put (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PUT)",
            tagIcons::http_put));
    icons.add(
        new IconCatalogEntry<>(
            "http-put-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PUT_OFF)",
            tagIcons::http_put_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-que (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_QUE)",
            tagIcons::http_que));
    icons.add(
        new IconCatalogEntry<>(
            "http-que-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_QUE_OFF)",
            tagIcons::http_que_off));
    icons.add(
        new IconCatalogEntry<>(
            "http-trace (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_TRACE)",
            tagIcons::http_trace));
    icons.add(
        new IconCatalogEntry<>(
            "http-trace-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.HTTP_TRACE_OFF)",
            tagIcons::http_trace_off));
    icons.add(
        new IconCatalogEntry<>(
            "load-balancer (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.LOAD_BALANCER)",
            tagIcons::load_balancer));
    icons.add(
        new IconCatalogEntry<>(
            "network (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.NETWORK)",
            tagIcons::network));
    icons.add(
        new IconCatalogEntry<>(
            "network-off (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.NETWORK_OFF)",
            tagIcons::network_off));
    icons.add(
        new IconCatalogEntry<>(
            "topology-bus (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_BUS)",
            tagIcons::topology_bus));
    icons.add(
        new IconCatalogEntry<>(
            "topology-complex (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_COMPLEX)",
            tagIcons::topology_complex));
    icons.add(
        new IconCatalogEntry<>(
            "topology-full (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_FULL)",
            tagIcons::topology_full));
    icons.add(
        new IconCatalogEntry<>(
            "topology-full-hierarchy (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_FULL_HIERARCHY)",
            tagIcons::topology_full_hierarchy));
    icons.add(
        new IconCatalogEntry<>(
            "topology-ring (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING)",
            tagIcons::topology_ring));
    icons.add(
        new IconCatalogEntry<>(
            "topology-ring-2 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING_2)",
            tagIcons::topology_ring_2));
    icons.add(
        new IconCatalogEntry<>(
            "topology-ring-3 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING_3)",
            tagIcons::topology_ring_3));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR)",
            tagIcons::topology_star));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star-2 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_2)",
            tagIcons::topology_star_2));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star-3 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_3)",
            tagIcons::topology_star_3));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star-ring (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING)",
            tagIcons::topology_star_ring));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star-ring-2 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING_2)",
            tagIcons::topology_star_ring_2));
    icons.add(
        new IconCatalogEntry<>(
            "topology-star-ring-3 (outline)",
            "TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING_3)",
            tagIcons::topology_star_ring_3));
    icons.add(
        new IconCatalogEntry<>(
            "binary-tree (filled)",
            "TablerIcon.create(TablerComputers.FilledIcon.BINARY_TREE)",
            tagIcons::binary_tree_filled));
    icons.add(
        new IconCatalogEntry<>(
            "binary-tree-2 (filled)",
            "TablerIcon.create(TablerComputers.FilledIcon.BINARY_TREE_2)",
            tagIcons::binary_tree_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cloud-computing (filled)",
            "TablerIcon.create(TablerComputers.FilledIcon.CLOUD_COMPUTING)",
            tagIcons::cloud_computing_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cloud-data-connection (filled)",
            "TablerIcon.create(TablerComputers.FilledIcon.CLOUD_DATA_CONNECTION)",
            tagIcons::cloud_data_connection_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
