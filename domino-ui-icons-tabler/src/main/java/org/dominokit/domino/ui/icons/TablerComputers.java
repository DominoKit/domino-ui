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

/** Tabler Computers catalog category. */
public interface TablerComputers {
  enum OutlineIcon implements TablerIconDefinition {
    BINARY(
        "binary",
        "<path d=\"M11 10v-5h-1m8 14v-5h-1\" />\n  <path d=\"M15 5.5a.5 .5 0 0 1 .5 -.5h2a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-2a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M10 14.5a.5 .5 0 0 1 .5 -.5h2a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-2a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M6 10h.01m-.01 9h.01\" />"),
    BINARY_OFF(
        "binary-off",
        "<path d=\"M11 7v-2h-1\" />\n  <path d=\"M18 19v-1\" />\n  <path d=\"M15.5 5h2a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-2a.5 .5 0 0 1 -.5 -.5v-4a.5 .5 0 0 1 .5 -.5\" />\n  <path d=\"M10.5 14h2a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-2a.5 .5 0 0 1 -.5 -.5v-4a.5 .5 0 0 1 .5 -.5\" />\n  <path d=\"M6 10v.01\" />\n  <path d=\"M6 19v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    BINARY_TREE(
        "binary-tree",
        "<path d=\"M6 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M16 4a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M16 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M11 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M21 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M5.058 18.306l2.88 -4.606\" />\n  <path d=\"M10.061 10.303l2.877 -4.604\" />\n  <path d=\"M10.065 13.705l2.876 4.6\" />\n  <path d=\"M15.063 5.7l2.881 4.61\" />"),
    BINARY_TREE_2(
        "binary-tree-2",
        "<path d=\"M14 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M7 14a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M21 14a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M6.316 12.496l4.368 -4.992\" />\n  <path d=\"M17.684 12.496l-4.366 -4.99\" />"),
    CLOUD_COMPUTING(
        "cloud-computing",
        "<path d=\"M6.657 16c-2.572 0 -4.657 -2.007 -4.657 -4.483c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.913 0 3.464 1.56 3.464 3.486c0 1.927 -1.551 3.487 -3.465 3.487h-11.878\" />\n  <path d=\"M12 16v5\" />\n  <path d=\"M16 16v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M8 16v4a1 1 0 0 1 -1 1h-4\" />"),
    CLOUD_DATA_CONNECTION(
        "cloud-data-connection",
        "<path d=\"M5 9.897c0 -1.714 1.46 -3.104 3.26 -3.104c.275 -1.22 1.255 -2.215 2.572 -2.611c1.317 -.397 2.77 -.134 3.811 .69c1.042 .822 1.514 2.08 1.239 3.3h.693a2.42 2.42 0 0 1 2.425 2.414a2.42 2.42 0 0 1 -2.425 2.414h-8.315c-1.8 0 -3.26 -1.39 -3.26 -3.103\" />\n  <path d=\"M12 13v3\" />\n  <path d=\"M10 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 18h7\" />\n  <path d=\"M3 18h7\" />"),
    ERROR_404(
        "error-404",
        "<path d=\"M3 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M17 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M21 8v8\" />\n  <path d=\"M10 10v4a2 2 0 1 0 4 0v-4a2 2 0 1 0 -4 0\" />"),
    ERROR_404_OFF(
        "error-404-off",
        "<path d=\"M3 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M17 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M21 8v8\" />\n  <path d=\"M10 10v4a2 2 0 1 0 4 0m0 -4a2 2 0 0 0 -2 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_CONNECT(
        "http-connect",
        "<path d=\"M7 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />\n  <path d=\"M17 16v-8l4 8v-8\" />\n  <path d=\"M12 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />"),
    HTTP_CONNECT_OFF(
        "http-connect-off",
        "<path d=\"M7 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />\n  <path d=\"M17 13v-5l4 8v-8\" />\n  <path d=\"M14 14a2 2 0 1 1 -4 0v-4m2 -2a2 2 0 0 1 2 2\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_DELETE(
        "http-delete",
        "<path d=\"M3 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2l-2 0\" />\n  <path d=\"M14 8h-4v8h4\" />\n  <path d=\"M10 12h2.5\" />\n  <path d=\"M17 8v8h4\" />"),
    HTTP_DELETE_OFF(
        "http-delete-off",
        "<path d=\"M3 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2l-2 0\" />\n  <path d=\"M14 8h-2m-2 2v6h4\" />\n  <path d=\"M10 12h2\" />\n  <path d=\"M17 8v5m3 3h1\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_GET(
        "http-get",
        "<path d=\"M7 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M14 8h-4v8h4\" />\n  <path d=\"M10 12h2.5\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />"),
    HTTP_GET_OFF(
        "http-get-off",
        "<path d=\"M7 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M14 8h-2m-2 2v6h4\" />\n  <path d=\"M10 12h2\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v7\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_HEAD(
        "http-head",
        "<path d=\"M3 16v-8\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M3 12h4\" />\n  <path d=\"M14 8h-4v8h4\" />\n  <path d=\"M10 12h2.5\" />\n  <path d=\"M17 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M17 13h4\" />"),
    HTTP_HEAD_OFF(
        "http-head-off",
        "<path d=\"M3 16v-8\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M3 12h4\" />\n  <path d=\"M14 8h-2m-2 2v6h4\" />\n  <path d=\"M10 12h2\" />\n  <path d=\"M17 13v-3a2 2 0 1 1 4 0v6\" />\n  <path d=\"M17 13h4\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_OPTIONS(
        "http-options",
        "<path d=\"M5 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M10 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />"),
    HTTP_OPTIONS_OFF(
        "http-options-off",
        "<path d=\"M5 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M10 12h2m2 -2a2 2 0 0 0 -2 -2m-2 2v6\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v7\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_PATCH(
        "http-patch",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M10 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M10 13h4\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />"),
    HTTP_PATCH_OFF(
        "http-patch-off",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M10 16v-6m2 -2a2 2 0 0 1 2 2m0 4v2\" />\n  <path d=\"M10 13h3\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v7\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_POST(
        "http-post",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M12 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1\" />"),
    HTTP_POST_OFF(
        "http-post-off",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M12 8a2 2 0 0 1 2 2m0 4a2 2 0 1 1 -4 0v-4\" />\n  <path d=\"M20 16a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_PUT(
        "http-put",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />\n  <path d=\"M10 8v6a2 2 0 1 0 4 0v-6\" />"),
    HTTP_PUT_OFF(
        "http-put-off",
        "<path d=\"M3 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M17 8h4\" />\n  <path d=\"M19 8v8\" />\n  <path d=\"M10 10v4a2 2 0 1 0 4 0m0 -4v-2\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_QUE(
        "http-que",
        "<path d=\"M5 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M6 15l1 1\" />\n  <path d=\"M21 8h-4v8h4\" />\n  <path d=\"M17 12h2.5\" />\n  <path d=\"M10 8v6a2 2 0 1 0 4 0v-6\" />"),
    HTTP_QUE_OFF(
        "http-que-off",
        "<path d=\"M5 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M6 15l1 1\" />\n  <path d=\"M21 8h-4v8h4\" />\n  <path d=\"M17 12h2.5\" />\n  <path d=\"M10 10v4a2 2 0 1 0 4 0m0 -4v-2\" />\n  <path d=\"M3 3l18 18\" />"),
    HTTP_TRACE(
        "http-trace",
        "<path d=\"M3 8h4\" />\n  <path d=\"M5 8v8\" />\n  <path d=\"M10 12h2a2 2 0 1 0 0 -4h-2v8\" />\n  <path d=\"M14 16l-3 -4\" />\n  <path d=\"M17 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M17 13h4\" />"),
    HTTP_TRACE_OFF(
        "http-trace-off",
        "<path d=\"M3 8h4\" />\n  <path d=\"M5 8v8\" />\n  <path d=\"M10 12h2m2 -2a2 2 0 0 0 -2 -2m-2 2v6\" />\n  <path d=\"M14 16l-3 -4\" />\n  <path d=\"M17 13v-3a2 2 0 1 1 4 0v6\" />\n  <path d=\"M17 13h4\" />\n  <path d=\"M3 3l18 18\" />"),
    LOAD_BALANCER(
        "load-balancer",
        "<path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M11 20a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M12 16v3\" />\n  <path d=\"M12 10v-7\" />\n  <path d=\"M9 6l3 -3l3 3\" />\n  <path d=\"M12 10v-7\" />\n  <path d=\"M9 6l3 -3l3 3\" />\n  <path d=\"M14.894 12.227l6.11 -2.224\" />\n  <path d=\"M17.159 8.21l3.845 1.793l-1.793 3.845\" />\n  <path d=\"M9.101 12.214l-6.075 -2.211\" />\n  <path d=\"M6.871 8.21l-3.845 1.793l1.793 3.845\" />"),
    NETWORK(
        "network",
        "<path d=\"M6 9a6 6 0 1 0 12 0a6 6 0 0 0 -12 0\" />\n  <path d=\"M12 3c1.333 .333 2 2.333 2 6s-.667 5.667 -2 6\" />\n  <path d=\"M12 3c-1.333 .333 -2 2.333 -2 6s.667 5.667 2 6\" />\n  <path d=\"M6 9h12\" />\n  <path d=\"M3 20h7\" />\n  <path d=\"M14 20h7\" />\n  <path d=\"M10 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 15v3\" />"),
    NETWORK_OFF(
        "network-off",
        "<path d=\"M6.528 6.536a6 6 0 0 0 7.942 7.933m2.247 -1.76a6 6 0 0 0 -8.427 -8.425\" />\n  <path d=\"M12 3c1.333 .333 2 2.333 2 6c0 .337 -.006 .66 -.017 .968m-.55 3.473c-.333 .884 -.81 1.403 -1.433 1.559\" />\n  <path d=\"M12 3c-.936 .234 -1.544 1.29 -1.822 3.167m-.16 3.838c.116 3.029 .776 4.695 1.982 4.995\" />\n  <path d=\"M6 9h3m4 0h5\" />\n  <path d=\"M3 20h7\" />\n  <path d=\"M14 20h7\" />\n  <path d=\"M10 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 15v3\" />\n  <path d=\"M3 3l18 18\" />"),
    TOPOLOGY_BUS(
        "topology-bus",
        "<path d=\"M14 10a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 10a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 10a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M2 16h20\" />\n  <path d=\"M4 12v4\" />\n  <path d=\"M12 12v4\" />\n  <path d=\"M20 12v4\" />"),
    TOPOLOGY_COMPLEX(
        "topology-complex",
        "<path d=\"M20 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M7.5 7.5l3 3\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 16v-8\" />\n  <path d=\"M8 6h8\" />\n  <path d=\"M16 18h-8\" />"),
    TOPOLOGY_FULL(
        "topology-full",
        "<path d=\"M20 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 16v-8\" />\n  <path d=\"M8 6h8\" />\n  <path d=\"M16 18h-8\" />\n  <path d=\"M7.5 7.5l9 9\" />\n  <path d=\"M7.5 16.5l9 -9\" />"),
    TOPOLOGY_FULL_HIERARCHY(
        "topology-full-hierarchy",
        "<path d=\"M20 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 16v-8\" />\n  <path d=\"M8 6h8\" />\n  <path d=\"M16 18h-8\" />\n  <path d=\"M7.5 7.5l3 3\" />\n  <path d=\"M13.5 13.5l3 3\" />\n  <path d=\"M16.5 7.5l-3 3\" />\n  <path d=\"M10.5 13.5l-3 3\" />"),
    TOPOLOGY_RING(
        "topology-ring",
        "<path d=\"M14 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 4a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M13.5 5.5l5 5\" />\n  <path d=\"M5.5 13.5l5 5\" />\n  <path d=\"M13.5 18.5l5 -5\" />\n  <path d=\"M10.5 5.5l-5 5\" />"),
    TOPOLOGY_RING_2(
        "topology-ring-2",
        "<path d=\"M14 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M7 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M21 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M7 18h10\" />\n  <path d=\"M18 16l-5 -8\" />\n  <path d=\"M11 8l-5 8\" />"),
    TOPOLOGY_RING_3(
        "topology-ring-3",
        "<path d=\"M8 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 8v8\" />\n  <path d=\"M18 16v-8\" />\n  <path d=\"M8 6h8\" />\n  <path d=\"M16 18h-8\" />"),
    TOPOLOGY_STAR(
        "topology-star",
        "<path d=\"M8 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M8 6a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M20 18a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M7.5 7.5l3 3\" />\n  <path d=\"M7.5 16.5l3 -3\" />\n  <path d=\"M13.5 13.5l3 3\" />\n  <path d=\"M16.5 7.5l-3 3\" />"),
    TOPOLOGY_STAR_2(
        "topology-star-2",
        "<path d=\"M14 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 4a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M12 6v4\" />\n  <path d=\"M12 14v4\" />"),
    TOPOLOGY_STAR_3(
        "topology-star-3",
        "<path d=\"M10 19a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M18 5a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M10 5a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M18 19a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M15 7l-2 3\" />\n  <path d=\"M9 7l2 3\" />\n  <path d=\"M11 14l-2 3\" />\n  <path d=\"M13 14l2 3\" />"),
    TOPOLOGY_STAR_RING(
        "topology-star-ring",
        "<path d=\"M14 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 4a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M13.5 5.5l5 5\" />\n  <path d=\"M5.5 13.5l5 5\" />\n  <path d=\"M13.5 18.5l5 -5\" />\n  <path d=\"M10.5 5.5l-5 5\" />\n  <path d=\"M12 6v4\" />\n  <path d=\"M12 14v4\" />"),
    TOPOLOGY_STAR_RING_2(
        "topology-star-ring-2",
        "<path d=\"M14 20a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 4a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M12 6v4\" />\n  <path d=\"M12 14v4\" />\n  <path d=\"M5.5 10.5l5 -5\" />\n  <path d=\"M13.5 5.5l5 5\" />\n  <path d=\"M18.5 13.5l-5 5\" />\n  <path d=\"M10.5 18.5l-5 -5\" />"),
    TOPOLOGY_STAR_RING_3(
        "topology-star-ring-3",
        "<path d=\"M10 19a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M18 5a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M10 5a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M18 19a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M22 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M15 7l-2 3\" />\n  <path d=\"M9 7l2 3\" />\n  <path d=\"M11 14l-2 3\" />\n  <path d=\"M13 14l2 3\" />\n  <path d=\"M10 5h4\" />\n  <path d=\"M10 19h4\" />\n  <path d=\"M17 17l2 -3\" />\n  <path d=\"M19 10l-2 -3\" />\n  <path d=\"M7 7l-2 3\" />\n  <path d=\"M5 14l2 3\" />");

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
    BINARY_TREE(
        "binary-tree",
        "<path d=\"M14 1a3 3 0 0 1 2.348 4.868l2 3.203q .317 -.071 .652 -.071a3 3 0 1 1 -2.347 1.132l-2 -3.203a3 3 0 0 1 -1.304 0l-2.001 3.203c.408 .513 .652 1.162 .652 1.868s-.244 1.356 -.653 1.868l2.002 3.203q .315 -.071 .651 -.071a3 3 0 1 1 -2.347 1.132l-2.003 -3.203a3 3 0 0 1 -1.302 0l-2.002 3.203a3 3 0 1 1 -1.696 -1.06l2.002 -3.204a3 3 0 0 1 2.998 -4.798l2.002 -3.202a3 3 0 0 1 2.348 -4.868\" />"),
    BINARY_TREE_2(
        "binary-tree-2",
        "<path d=\"M12 3a3 3 0 0 1 2.616 4.47l3.274 3.742a3 3 0 1 1 -1.505 1.318l-3.275 -3.743l-.11 .042v6.342a3.001 3.001 0 1 1 -2 0v-6.342l-.111 -.041l-3.274 3.742a3 3 0 1 1 -1.505 -1.318l3.273 -3.742a3 3 0 0 1 2.617 -4.47\" />"),
    CLOUD_COMPUTING(
        "cloud-computing",
        "<path d=\"M9 20a2 2 0 0 1 -2 2h-4a1 1 0 0 1 0 -2h4v-2.997l-.343 .001a1 1 0 0 1 -.117 -.007l-.105 -.001c-2.94 -.11 -5.317 -2.399 -5.43 -5.263l-.005 -.216c0 -2.747 2.08 -5.01 4.784 -5.417l.114 -.016l.07 -.181c.663 -1.62 2.056 -2.906 3.829 -3.518l.244 -.08c2.194 -.667 4.614 -.224 6.36 1.176c1.385 1.108 2.187 2.686 2.25 4.34l.004 .212l.091 .003c2.3 .107 4.143 1.961 4.25 4.27l.004 .211c0 2.478 -1.997 4.487 -4.465 4.487h-1.535v2.996h4a1 1 0 0 1 0 2h-4a2 2 0 0 1 -2 -2v-2.997h-2v3.997a1 1 0 0 1 -2 0v-3.997h-2z\" />"),
    CLOUD_DATA_CONNECTION(
        "cloud-data-connection",
        "<path d=\"M15.262 4.087c.974 .768 1.566 1.848 1.678 2.997l.007 .107l.18 .025a3.42 3.42 0 0 1 2.867 3.184l.006 .188a3.42 3.42 0 0 1 -3.425 3.412h-3.575l.001 1.171a3 3 0 0 1 1.829 1.829h6.17a1 1 0 0 1 0 2h-6.17a3.001 3.001 0 0 1 -5.66 0h-6.17a1 1 0 0 1 0 -2h6.171a3 3 0 0 1 1.829 -1.83v-1.17h-2.74c-2.341 0 -4.26 -1.826 -4.26 -4.103c0 -2.001 1.481 -3.655 3.43 -4.026l.086 -.015l.049 -.112c.514 -1.124 1.508 -2.01 2.756 -2.447l.222 -.072c1.627 -.49 3.42 -.166 4.72 .862\" />");

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

  default TablerIcon binary() {
    return TablerIcon.create(TablerComputers.OutlineIcon.BINARY);
  }

  default TablerIcon binary_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.BINARY_OFF);
  }

  default TablerIcon binary_tree() {
    return TablerIcon.create(TablerComputers.OutlineIcon.BINARY_TREE);
  }

  default TablerIcon binary_tree_2() {
    return TablerIcon.create(TablerComputers.OutlineIcon.BINARY_TREE_2);
  }

  default TablerIcon cloud_computing() {
    return TablerIcon.create(TablerComputers.OutlineIcon.CLOUD_COMPUTING);
  }

  default TablerIcon cloud_data_connection() {
    return TablerIcon.create(TablerComputers.OutlineIcon.CLOUD_DATA_CONNECTION);
  }

  default TablerIcon error_404() {
    return TablerIcon.create(TablerComputers.OutlineIcon.ERROR_404);
  }

  default TablerIcon error_404_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.ERROR_404_OFF);
  }

  default TablerIcon http_connect() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_CONNECT);
  }

  default TablerIcon http_connect_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_CONNECT_OFF);
  }

  default TablerIcon http_delete() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_DELETE);
  }

  default TablerIcon http_delete_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_DELETE_OFF);
  }

  default TablerIcon http_get() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_GET);
  }

  default TablerIcon http_get_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_GET_OFF);
  }

  default TablerIcon http_head() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_HEAD);
  }

  default TablerIcon http_head_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_HEAD_OFF);
  }

  default TablerIcon http_options() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_OPTIONS);
  }

  default TablerIcon http_options_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_OPTIONS_OFF);
  }

  default TablerIcon http_patch() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PATCH);
  }

  default TablerIcon http_patch_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PATCH_OFF);
  }

  default TablerIcon http_post() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_POST);
  }

  default TablerIcon http_post_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_POST_OFF);
  }

  default TablerIcon http_put() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PUT);
  }

  default TablerIcon http_put_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_PUT_OFF);
  }

  default TablerIcon http_que() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_QUE);
  }

  default TablerIcon http_que_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_QUE_OFF);
  }

  default TablerIcon http_trace() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_TRACE);
  }

  default TablerIcon http_trace_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.HTTP_TRACE_OFF);
  }

  default TablerIcon load_balancer() {
    return TablerIcon.create(TablerComputers.OutlineIcon.LOAD_BALANCER);
  }

  default TablerIcon network() {
    return TablerIcon.create(TablerComputers.OutlineIcon.NETWORK);
  }

  default TablerIcon network_off() {
    return TablerIcon.create(TablerComputers.OutlineIcon.NETWORK_OFF);
  }

  default TablerIcon topology_bus() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_BUS);
  }

  default TablerIcon topology_complex() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_COMPLEX);
  }

  default TablerIcon topology_full() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_FULL);
  }

  default TablerIcon topology_full_hierarchy() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_FULL_HIERARCHY);
  }

  default TablerIcon topology_ring() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING);
  }

  default TablerIcon topology_ring_2() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING_2);
  }

  default TablerIcon topology_ring_3() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_RING_3);
  }

  default TablerIcon topology_star() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR);
  }

  default TablerIcon topology_star_2() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_2);
  }

  default TablerIcon topology_star_3() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_3);
  }

  default TablerIcon topology_star_ring() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING);
  }

  default TablerIcon topology_star_ring_2() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING_2);
  }

  default TablerIcon topology_star_ring_3() {
    return TablerIcon.create(TablerComputers.OutlineIcon.TOPOLOGY_STAR_RING_3);
  }

  default TablerIcon binary_tree_filled() {
    return TablerIcon.create(TablerComputers.FilledIcon.BINARY_TREE);
  }

  default TablerIcon binary_tree_2_filled() {
    return TablerIcon.create(TablerComputers.FilledIcon.BINARY_TREE_2);
  }

  default TablerIcon cloud_computing_filled() {
    return TablerIcon.create(TablerComputers.FilledIcon.CLOUD_COMPUTING);
  }

  default TablerIcon cloud_data_connection_filled() {
    return TablerIcon.create(TablerComputers.FilledIcon.CLOUD_DATA_CONNECTION);
  }
}
