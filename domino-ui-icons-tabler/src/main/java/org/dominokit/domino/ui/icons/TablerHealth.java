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

/** Tabler Health catalog category. */
public interface TablerHealth {
  enum OutlineIcon implements TablerIconDefinition {
    ACCESSIBLE(
        "accessible",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 16.5l2 -3l2 3m-2 -3v-2l3 -1m-6 0l3 1\" />\n  <path d=\"M11.5 7.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />"),
    ACCESSIBLE_OFF(
        "accessible-off",
        "<path d=\"M10 16.5l2 -3l2 3m-2 -3v-1.5m2.627 -1.376l.373 -.124m-6 0l2.231 .744\" />\n  <path d=\"M20.042 16.045a9 9 0 0 0 -12.087 -12.087m-2.318 1.677a9 9 0 1 0 12.725 12.73\" />\n  <path d=\"M12 8a.5 .5 0 1 0 -.5 -.5\" />\n  <path d=\"M3 3l18 18\" />"),
    ACTIVITY("activity", "<path d=\"M3 12h4l3 8l4 -16l3 8h4\" />"),
    ACTIVITY_HEARTBEAT("activity-heartbeat", "<path d=\"M3 12h4.5l1.5 -6l4 12l2 -9l1.5 3h4.5\" />"),
    BABY_BOTTLE(
        "baby-bottle",
        "<path d=\"M5 10h14\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 4a5 5 0 0 1 5 5v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2v-11a5 5 0 0 1 5 -5\" />"),
    BABY_CARRIAGE(
        "baby-carriage",
        "<path d=\"M6 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 5h2.5l1.632 4.897a6 6 0 0 0 5.693 4.103h2.675a5.5 5.5 0 0 0 0 -11h-.5v6\" />\n  <path d=\"M6 9h14\" />\n  <path d=\"M9 17l1 -3\" />\n  <path d=\"M16 14l1 3\" />"),
    BANDAGE(
        "bandage",
        "<path d=\"M14 12l0 .01\" />\n  <path d=\"M10 12l0 .01\" />\n  <path d=\"M12 10l0 .01\" />\n  <path d=\"M12 14l0 .01\" />\n  <path d=\"M4.5 12.5l8 -8a4.94 4.94 0 0 1 7 7l-8 8a4.94 4.94 0 0 1 -7 -7\" />"),
    BANDAGE_OFF(
        "bandage-off",
        "<path d=\"M10 12v.01\" />\n  <path d=\"M12 14v.01\" />\n  <path d=\"M10.513 6.487l1.987 -1.987a4.95 4.95 0 0 1 7 7l-2.018 2.018m-1.982 1.982l-4 4a4.95 4.95 0 0 1 -7 -7l4 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    BLIND(
        "blind",
        "<path d=\"M9 4a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M4 21l3 -4\" />\n  <path d=\"M13 21l-2 -4l-3 -3l1 -6\" />\n  <path d=\"M3 12l2 -3l4 -1l6 4\" />\n  <path d=\"M16.5 14l3.5 7\" />"),
    BRAILLE(
        "braille",
        "<path d=\"M15 5a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M7 5a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M7 19a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"M8 12h.01\" />\n  <path d=\"M16 19h.01\" />"),
    BRAIN(
        "brain",
        "<path d=\"M15.5 13a3.5 3.5 0 0 0 -3.5 3.5v1a3.5 3.5 0 0 0 7 0v-1.8\" />\n  <path d=\"M8.5 13a3.5 3.5 0 0 1 3.5 3.5v1a3.5 3.5 0 0 1 -7 0v-1.8\" />\n  <path d=\"M17.5 16a3.5 3.5 0 0 0 0 -7h-.5\" />\n  <path d=\"M19 9.3v-2.8a3.5 3.5 0 0 0 -7 0\" />\n  <path d=\"M6.5 16a3.5 3.5 0 0 1 0 -7h.5\" />\n  <path d=\"M5 9.3v-2.8a3.5 3.5 0 0 1 7 0v10\" />"),
    CANE(
        "cane",
        "<path d=\"M9 21l6.324 -11.69c.54 -.974 1.756 -4.104 -1.499 -5.762c-3.255 -1.657 -5.175 .863 -5.825 2.032\" />"),
    CHECKUP_LIST(
        "checkup-list",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 14h.01\" />\n  <path d=\"M9 17h.01\" />\n  <path d=\"M12 16l1 1l3 -3\" />"),
    CRUTCHES(
        "crutches",
        "<path d=\"M8 5a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11 21h2\" />\n  <path d=\"M12 21v-4.092a3 3 0 0 1 .504 -1.664l.992 -1.488a3 3 0 0 0 .504 -1.664v-5.092\" />\n  <path d=\"M12 21v-4.092a3 3 0 0 0 -.504 -1.664l-.992 -1.488a3 3 0 0 1 -.504 -1.664v-5.092\" />\n  <path d=\"M10 11h4\" />"),
    CRUTCHES_OFF(
        "crutches-off",
        "<path d=\"M8.178 4.174a2 2 0 0 1 1.822 -1.174h4a2 2 0 1 1 0 4h-3\" />\n  <path d=\"M11 21h2\" />\n  <path d=\"M12 21v-4.092a3 3 0 0 1 .504 -1.664l.992 -1.488a3 3 0 0 0 .097 -.155m.407 -3.601v-3\" />\n  <path d=\"M12 21v-4.092a3 3 0 0 0 -.504 -1.664l-.992 -1.488a3 3 0 0 1 -.504 -1.664v-2.092\" />\n  <path d=\"M10 11h1\" />\n  <path d=\"M3 3l18 18\" />"),
    DEAF(
        "deaf",
        "<path d=\"M6 10a7 7 0 1 1 13 3.6a10 10 0 0 1 -2 2a8 8 0 0 0 -2 3a4.5 4.5 0 0 1 -6.8 1.4\" />\n  <path d=\"M10 10a3 3 0 1 1 5 2.2\" />\n  <path d=\"M5 13l4 4\" />\n  <path d=\"M9 13l-4 4\" />"),
    DENTAL(
        "dental",
        "<path d=\"M12 5.5c-1.074 -.586 -2.583 -1.5 -4 -1.5c-2.1 0 -4 1.247 -4 5c0 4.899 1.056 8.41 2.671 10.537c.573 .756 1.97 .521 2.567 -.236c.398 -.505 .819 -1.439 1.262 -2.801c.292 -.771 .892 -1.504 1.5 -1.5c.602 0 1.21 .737 1.5 1.5c.443 1.362 .864 2.295 1.262 2.8c.597 .759 2 .993 2.567 .237c1.615 -2.127 2.671 -5.637 2.671 -10.537c0 -3.74 -1.908 -5 -4 -5c-1.423 0 -2.92 .911 -4 1.5\" />\n  <path d=\"M12 5.5l3 1.5\" />"),
    DENTAL_OFF(
        "dental-off",
        "<path d=\"M19.277 15.281c.463 -1.75 .723 -3.844 .723 -6.281c0 -3.74 -1.908 -5 -4 -5c-1.423 0 -2.92 .911 -4 1.5c-1.074 -.586 -2.583 -1.5 -4 -1.5m-2.843 1.153c-.707 .784 -1.157 2.017 -1.157 3.847c0 4.899 1.056 8.41 2.671 10.537c.573 .756 1.97 .521 2.567 -.236c.398 -.505 .819 -1.439 1.262 -2.801c.292 -.771 .892 -1.504 1.5 -1.5c.602 0 1.21 .737 1.5 1.5c.443 1.362 .864 2.295 1.262 2.8c.597 .759 2 .993 2.567 .237c.305 -.402 .59 -.853 .852 -1.353\" />\n  <path d=\"M12 5.5l3 1.5\" />\n  <path d=\"M3 3l18 18\" />"),
    DISABLED(
        "disabled",
        "<path d=\"M9 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M11 7l0 8l4 0l4 5\" />\n  <path d=\"M11 11l5 0\" />\n  <path d=\"M7 11.5a5 5 0 1 0 6 7.5\" />"),
    DISABLED_2(
        "disabled-2",
        "<path d=\"M15 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M9 11a5 5 0 1 0 3.95 7.95\" />\n  <path d=\"M19 20l-4 -5h-4l3 -5l-4 -3l-4 1\" />"),
    DISABLED_OFF(
        "disabled-off",
        "<path d=\"M11 7a2 2 0 1 0 -2 -2\" />\n  <path d=\"M11 11v4h4l4 5\" />\n  <path d=\"M15 11h1\" />\n  <path d=\"M7 11.5a5 5 0 1 0 6 7.5\" />\n  <path d=\"M3 3l18 18\" />"),
    DNA(
        "dna",
        "<path d=\"M14.828 14.828a4 4 0 1 0 -5.656 -5.656a4 4 0 0 0 5.656 5.656\" />\n  <path d=\"M9.172 20.485a4 4 0 1 0 -5.657 -5.657\" />\n  <path d=\"M14.828 3.515a4 4 0 0 0 5.657 5.657\" />"),
    DNA_2(
        "dna-2",
        "<path d=\"M17 3v1c-.01 3.352 -1.68 6.023 -5.008 8.014c-3.328 1.99 3.336 -2 .008 -.014c-3.328 1.99 -5 4.662 -5.008 8.014v1\" />\n  <path d=\"M17 21.014v-1c-.01 -3.352 -1.68 -6.023 -5.008 -8.014c-3.328 -1.99 3.336 2 .008 .014c-3.328 -1.991 -5 -4.662 -5.008 -8.014v-1\" />\n  <path d=\"M7 4h10\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M8 8h8\" />\n  <path d=\"M8 16h8\" />"),
    DNA_2_OFF(
        "dna-2-off",
        "<path d=\"M17 3v1c-.007 2.46 -.91 4.554 -2.705 6.281m-2.295 1.719c-3.328 1.99 -5 4.662 -5.008 8.014v1\" />\n  <path d=\"M17 21.014v-1c0 -1.44 -.315 -2.755 -.932 -3.944m-4.068 -4.07c-1.903 -1.138 -3.263 -2.485 -4.082 -4.068\" />\n  <path d=\"M8 4h9\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M12 8h4\" />\n  <path d=\"M8 16h8\" />\n  <path d=\"M3 3l18 18\" />"),
    DNA_OFF(
        "dna-off",
        "<path d=\"M16 12a3.898 3.898 0 0 0 -1.172 -2.828a4.027 4.027 0 0 0 -2.828 -1.172m-2.828 1.172a4 4 0 1 0 5.656 5.656\" />\n  <path d=\"M9.172 20.485a4 4 0 1 0 -5.657 -5.657\" />\n  <path d=\"M14.828 3.515a4 4 0 1 0 5.657 5.657\" />\n  <path d=\"M3 3l18 18\" />"),
    EAR(
        "ear",
        "<path d=\"M6 10a7 7 0 1 1 13 3.6a10 10 0 0 1 -2 2a8 8 0 0 0 -2 3a4.5 4.5 0 0 1 -6.8 1.4\" />\n  <path d=\"M10 10a3 3 0 1 1 5 2.2\" />"),
    EAR_OFF(
        "ear-off",
        "<path d=\"M6 10c0 -1.146 .277 -2.245 .78 -3.219m1.792 -2.208a7 7 0 0 1 10.428 9.027a10 10 0 0 1 -.633 .762m-2.045 1.96a8 8 0 0 0 -1.322 2.278a4.5 4.5 0 0 1 -6.8 1.4\" />\n  <path d=\"M11.42 7.414a3 3 0 0 1 4.131 4.13\" />\n  <path d=\"M3 3l18 18\" />"),
    EMERGENCY_BED(
        "emergency-bed",
        "<path d=\"M14 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 8l2.1 2.8a3 3 0 0 0 2.4 1.2h11.5\" />\n  <path d=\"M10 6h4\" />\n  <path d=\"M12 4v4\" />\n  <path d=\"M12 12v2l-2.5 2.5\" />\n  <path d=\"M14.5 16.5l-2.5 -2.5\" />"),
    EMPATHIZE(
        "empathize",
        "<path d=\"M9.5 5.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M12 21.368l5.095 -5.096a3.088 3.088 0 1 0 -4.367 -4.367l-.728 .727l-.728 -.727a3.088 3.088 0 1 0 -4.367 4.367l5.095 5.096\" />"),
    EMPATHIZE_OFF(
        "empathize-off",
        "<path d=\"M12 8a2.5 2.5 0 1 0 -2.5 -2.5\" />\n  <path d=\"M12.317 12.315l-.317 .317l-.728 -.727a3.088 3.088 0 1 0 -4.367 4.367l5.095 5.096l4.689 -4.69m1.324 -2.673a3.087 3.087 0 0 0 -3.021 -3.018\" />\n  <path d=\"M3 3l18 18\" />"),
    EYE_BITCOIN(
        "eye-bitcoin",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M13.193 17.924q -.585 .075 -1.193 .076q -5.4 0 -9 -6q 3.6 -6 9 -6q 4.508 0 7.761 4.181\" />\n  <path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />"),
    EYE_DISCOUNT(
        "eye-discount",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    EYE_DOTTED(
        "eye-dotted",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M21 12h.01\" />\n  <path d=\"M3 12h.01\" />\n  <path d=\"M5 15h.01\" />\n  <path d=\"M5 9h.01\" />\n  <path d=\"M19 15h.01\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M12 6h.01\" />\n  <path d=\"M8 17h.01\" />\n  <path d=\"M8 7h.01\" />\n  <path d=\"M16 17h.01\" />\n  <path d=\"M16 7h.01\" />\n  <path d=\"M19 9h.01\" />"),
    EYE_TABLE(
        "eye-table",
        "<path d=\"M8 18h-.011\" />\n  <path d=\"M12 18h-.011\" />\n  <path d=\"M16 18h-.011\" />\n  <path d=\"M4 3h16\" />\n  <path d=\"M5 3v17a1 1 0 0 0 1 1h12a1 1 0 0 0 1 -1v-17\" />\n  <path d=\"M14 7h-4\" />\n  <path d=\"M9 15h1\" />\n  <path d=\"M14 15h1\" />\n  <path d=\"M12 11v-4\" />"),
    EYEGLASS(
        "eyeglass",
        "<path d=\"M8 4h-2l-3 10\" />\n  <path d=\"M16 4h2l3 10\" />\n  <path d=\"M10 16l4 0\" />\n  <path d=\"M21 16.5a3.5 3.5 0 0 1 -7 0v-2.5h7v2.5\" />\n  <path d=\"M10 16.5a3.5 3.5 0 0 1 -7 0v-2.5h7v2.5\" />"),
    EYEGLASS_2(
        "eyeglass-2",
        "<path d=\"M8 4h-2l-3 10v2.5\" />\n  <path d=\"M16 4h2l3 10v2.5\" />\n  <path d=\"M10 16l4 0\" />\n  <path d=\"M14 16.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M3 16.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />"),
    EYEGLASS_OFF(
        "eyeglass-off",
        "<path d=\"M5.536 5.546l-2.536 8.454\" />\n  <path d=\"M16 4h2l3 10\" />\n  <path d=\"M10 16h4\" />\n  <path d=\"M19.426 19.423a3.5 3.5 0 0 1 -5.426 -2.923v-2.5m4 0h3v2.5c0 .157 -.01 .312 -.03 .463\" />\n  <path d=\"M10 16.5a3.5 3.5 0 0 1 -7 0v-2.5h7v2.5\" />\n  <path d=\"M3 3l18 18\" />"),
    FACE_MASK(
        "face-mask",
        "<path d=\"M5 14.5h-.222c-1.535 0 -2.778 -1.12 -2.778 -2.5s1.243 -2.5 2.778 -2.5h.222\" />\n  <path d=\"M19 14.5h.222c1.534 0 2.778 -1.12 2.778 -2.5s-1.244 -2.5 -2.778 -2.5h-.222\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M9 14h6\" />\n  <path d=\"M12.55 18.843l5 -1.429a2 2 0 0 0 1.45 -1.923v-6.981a2 2 0 0 0 -1.45 -1.923l-5 -1.429a2 2 0 0 0 -1.1 0l-5 1.429a2 2 0 0 0 -1.45 1.922v6.982a2 2 0 0 0 1.45 1.923l5 1.429a2 2 0 0 0 1.1 0\" />"),
    FACE_MASK_OFF(
        "face-mask-off",
        "<path d=\"M5 14.5h-.222c-1.535 0 -2.778 -1.12 -2.778 -2.5s1.243 -2.5 2.778 -2.5h.222\" />\n  <path d=\"M19 14.5h.222c1.534 0 2.778 -1.12 2.778 -2.5s-1.244 -2.5 -2.778 -2.5h-.222\" />\n  <path d=\"M9 10h1m4 0h1\" />\n  <path d=\"M9 14h5\" />\n  <path d=\"M19 15v-6.49a2 2 0 0 0 -1.45 -1.923l-5 -1.429a2 2 0 0 0 -1.1 0l-1.788 .511m-3.118 .891l-.094 .027a2 2 0 0 0 -1.45 1.922v6.982a2 2 0 0 0 1.45 1.923l5 1.429a2 2 0 0 0 1.1 0l4.899 -1.4\" />\n  <path d=\"M3 3l18 18\" />"),
    FALL(
        "fall",
        "<path d=\"M11 21l1 -5l-1 -4l-3 -4h4l3 -3\" />\n  <path d=\"M6 16l-1 -4l3 -4\" />\n  <path d=\"M5 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M13.5 12h2.5l4 2\" />"),
    FINGERPRINT_SCAN(
        "fingerprint-scan",
        "<path d=\"M9 11a3 3 0 0 1 6 0c0 1.657 .612 3.082 1 4\" />\n  <path d=\"M12 11v1.75c-.001 1.11 .661 2.206 1 3.25\" />\n  <path d=\"M9 14.25c.068 .58 .358 1.186 .5 1.75\" />\n  <path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />"),
    FIRST_AID_KIT(
        "first-aid-kit",
        "<path d=\"M8 8v-2a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v2\" />\n  <path d=\"M4 10a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M12 12v4\" />"),
    FIRST_AID_KIT_OFF(
        "first-aid-kit-off",
        "<path d=\"M8.595 4.577a2 2 0 0 1 1.405 -.577h4a2 2 0 0 1 2 2v2\" />\n  <path d=\"M12 8h6a2 2 0 0 1 2 2v6m-.576 3.405a2 2 0 0 1 -1.424 .595h-12a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M12 12v4\" />\n  <path d=\"M3 3l18 18\" />"),
    FLASK(
        "flask",
        "<path d=\"M9 3l6 0\" />\n  <path d=\"M10 9l4 0\" />\n  <path d=\"M10 3v6l-4 11a.7 .7 0 0 0 .5 1h11a.7 .7 0 0 0 .5 -1l-4 -11v-6\" />"),
    FLASK_2(
        "flask-2",
        "<path d=\"M6.1 15h11.8\" />\n  <path d=\"M14 3v7.342a6 6 0 0 1 1.318 10.658h-6.635a6 6 0 0 1 1.317 -10.66v-7.34h4\" />\n  <path d=\"M9 3h6\" />"),
    FLASK_2_OFF(
        "flask-2-off",
        "<path d=\"M6.1 15h8.9\" />\n  <path d=\"M17.742 17.741a6 6 0 0 1 -2.424 3.259h-6.635a6 6 0 0 1 1.317 -10.66v-.326m0 -4.014v-3h4v7m.613 .598a6 6 0 0 1 2.801 2.817\" />\n  <path d=\"M9 3h6\" />\n  <path d=\"M3 3l18 18\" />"),
    FLASK_OFF(
        "flask-off",
        "<path d=\"M9 3h6\" />\n  <path d=\"M13 9h1\" />\n  <path d=\"M10 3v3m-.268 3.736l-3.732 10.264a.7 .7 0 0 0 .5 1h11a.7 .7 0 0 0 .5 -1l-1.143 -3.142m-2.288 -6.294l-.569 -1.564v-6\" />\n  <path d=\"M3 3l18 18\" />"),
    FOOTSTEPS(
        "footsteps",
        "<path d=\"M4 16.5a2.5 2.5 0 0 0 5 0a1.5 1.5 0 0 0 -1.5 -1.5h-2a1.5 1.5 0 0 0 -1.5 1.5\" />\n  <path d=\"M15 18.5a2.5 2.5 0 0 0 5 0a1.5 1.5 0 0 0 -1.5 -1.5h-2a1.5 1.5 0 0 0 -1.5 1.5\" />\n  <path d=\"M8.52 12h-4.04c-.348 0 -.678 -.179 -.823 -.496c-1.326 -2.904 -.774 -8.504 2.843 -8.504s4.17 5.6 2.843 8.504c-.145 .317 -.475 .496 -.824 .496\" />\n  <path d=\"M19.52 14h-4.04c-.348 0 -.678 -.179 -.823 -.496c-1.326 -2.904 -.774 -8.504 2.843 -8.504s4.17 5.6 2.843 8.504c-.145 .317 -.475 .496 -.824 .496\" />"),
    HAND_SANITIZER(
        "hand-sanitizer",
        "<path d=\"M7 21h10v-10a3 3 0 0 0 -3 -3h-4a3 3 0 0 0 -3 3v10\" />\n  <path d=\"M15 3h-6a2 2 0 0 0 -2 2\" />\n  <path d=\"M12 3v5\" />\n  <path d=\"M12 11v4\" />\n  <path d=\"M10 13h4\" />"),
    HEART_BITCOIN(
        "heart-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M13 19l-1 1l-7.5 -7.428a5 5 0 1 1 7.5 -6.566a5 5 0 0 1 8.785 4.444\" />"),
    HEART_BROKEN(
        "heart-broken",
        "<path d=\"M19.5 12.572l-7.5 7.428l-7.5 -7.428a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572\" />\n  <path d=\"M12 6l-2 4l4 3l-2 4v3\" />"),
    HEART_DISCOUNT(
        "heart-discount",
        "<path d=\"M13 19l-1 1l-7.5 -7.428a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    HEART_HANDSHAKE(
        "heart-handshake",
        "<path d=\"M19.5 12.572l-7.5 7.428l-7.5 -7.428a5 5 0 1 1 7.5 -6.566a5 5 0 1 1 7.5 6.572\" />\n  <path d=\"M12 6l-3.293 3.293a1 1 0 0 0 0 1.414l.543 .543c.69 .69 1.81 .69 2.5 0l1 -1a3.182 3.182 0 0 1 4.5 0l2.25 2.25\" />\n  <path d=\"M12.5 15.5l2 2\" />\n  <path d=\"M15 13l2 2\" />"),
    HEART_RATE_MONITOR(
        "heart-rate-monitor",
        "<path d=\"M3 5a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -10\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 16v4\" />\n  <path d=\"M7 10h2l2 3l2 -6l1 3h3\" />"),
    HEARTBEAT(
        "heartbeat",
        "<path d=\"M19.5 13.572l-7.5 7.428l-2.896 -2.868m-6.117 -8.104a5 5 0 0 1 9.013 -3.022a5 5 0 1 1 7.5 6.572\" />\n  <path d=\"M3 13h2l2 3l2 -6l1 3h3\" />"),
    HOSPITAL(
        "hospital",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M10 16v-8\" />\n  <path d=\"M14 16v-8\" />\n  <path d=\"M10 12h4\" />"),
    HOSPITAL_CIRCLE(
        "hospital-circle",
        "<path d=\"M10 16v-8\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M14 16v-8\" />\n  <path d=\"M10 12h4\" />"),
    LUNGS(
        "lungs",
        "<path d=\"M6.081 20c1.612 0 2.919 -1.335 2.919 -2.98v-9.763c0 -.694 -.552 -1.257 -1.232 -1.257c-.205 0 -.405 .052 -.584 .15l-.13 .083c-1.46 1.059 -2.432 2.647 -3.404 5.824c-.42 1.37 -.636 2.962 -.648 4.775c-.012 1.675 1.261 3.054 2.877 3.161l.203 .007\" />\n  <path d=\"M17.92 20c-1.613 0 -2.92 -1.335 -2.92 -2.98v-9.763c0 -.694 .552 -1.257 1.233 -1.257c.204 0 .405 .052 .584 .15l.13 .083c1.46 1.059 2.432 2.647 3.405 5.824c.42 1.37 .636 2.962 .648 4.775c.012 1.675 -1.261 3.054 -2.878 3.161l-.202 .007\" />\n  <path d=\"M9 12a3 3 0 0 0 3 -3a3 3 0 0 0 3 3\" />\n  <path d=\"M12 4v5\" />"),
    LUNGS_OFF(
        "lungs-off",
        "<path d=\"M6.583 6.608c-1.206 1.058 -2.07 2.626 -2.933 5.449c-.42 1.37 -.636 2.962 -.648 4.775c-.012 1.675 1.261 3.054 2.877 3.161l.203 .007c1.611 0 2.918 -1.335 2.918 -2.98v-8.02\" />\n  <path d=\"M15 11v-3.743c0 -.694 .552 -1.257 1.233 -1.257c.204 0 .405 .052 .584 .15l.13 .083c1.46 1.059 2.432 2.647 3.405 5.824c.42 1.37 .636 2.962 .648 4.775c0 .063 0 .125 0 .187m-1.455 2.51c-.417 .265 -.9 .43 -1.419 .464l-.202 .007c-1.613 0 -2.92 -1.335 -2.92 -2.98v-2.02\" />\n  <path d=\"M9 12a2.99 2.99 0 0 0 2.132 -.89\" />\n  <path d=\"M12 4v4\" />\n  <path d=\"M3 3l18 18\" />"),
    MASSAGE(
        "massage",
        "<path d=\"M3 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 22l4 -2v-3h12\" />\n  <path d=\"M11 20h9\" />\n  <path d=\"M8 14l3 -2l1 -4c3 1 3 4 3 6\" />"),
    MEDICINE_SYRUP(
        "medicine-syrup",
        "<path d=\"M8 21h8a1 1 0 0 0 1 -1v-10a3 3 0 0 0 -3 -3h-4a3 3 0 0 0 -3 3v10a1 1 0 0 0 1 1\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M12 12v4\" />\n  <path d=\"M10 7v-3a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v3\" />"),
    MICROSCOPE(
        "microscope",
        "<path d=\"M5 21h14\" />\n  <path d=\"M6 18h2\" />\n  <path d=\"M7 18v3\" />\n  <path d=\"M9 11l3 3l6 -6l-3 -3l-6 6\" />\n  <path d=\"M10.5 12.5l-1.5 1.5\" />\n  <path d=\"M17 3l3 3\" />\n  <path d=\"M12 21a6 6 0 0 0 3.715 -10.712\" />"),
    MICROSCOPE_OFF(
        "microscope-off",
        "<path d=\"M5 21h14\" />\n  <path d=\"M6 18h2\" />\n  <path d=\"M7 18v3\" />\n  <path d=\"M10 10l-1 1l3 3l1 -1m2 -2l3 -3l-3 -3l-3 3\" />\n  <path d=\"M10.5 12.5l-1.5 1.5\" />\n  <path d=\"M17 3l3 3\" />\n  <path d=\"M12 21a6 6 0 0 0 5.457 -3.505m.441 -3.599a6 6 0 0 0 -2.183 -3.608\" />\n  <path d=\"M3 3l18 18\" />"),
    NURSE(
        "nurse",
        "<path d=\"M12 5c2.941 0 6.685 1.537 9 3l-2 11h-14l-2 -11c2.394 -1.513 6.168 -3.005 9 -3\" />\n  <path d=\"M10 12h4\" />\n  <path d=\"M12 10v4\" />"),
    OLD(
        "old",
        "<path d=\"M11 21l-1 -4l-2 -3v-6\" />\n  <path d=\"M5 14l-1 -3l4 -3l3 2l3 .5\" />\n  <path d=\"M7 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 17l-2 4\" />\n  <path d=\"M16 21v-8.5a1.5 1.5 0 0 1 3 0v.5\" />"),
    PHYSIOTHERAPIST(
        "physiotherapist",
        "<path d=\"M9 15l-1 -3l4 -2l4 1h3.5\" />\n  <path d=\"M3 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 6a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M12 17v-7\" />\n  <path d=\"M8 20h7l1 -4l4 -2\" />\n  <path d=\"M18 20h3\" />"),
    PILL(
        "pill",
        "<path d=\"M4.5 12.5l8 -8a4.94 4.94 0 0 1 7 7l-8 8a4.94 4.94 0 0 1 -7 -7\" />\n  <path d=\"M8.5 8.5l7 7\" />"),
    PILL_OFF(
        "pill-off",
        "<path d=\"M10.495 6.505l2 -2a4.95 4.95 0 0 1 7 7l-2 2m-2 2l-4 4a4.95 4.95 0 0 1 -7 -7l4 -4\" />\n  <path d=\"M8.5 8.5l7 7\" />\n  <path d=\"M3 3l18 18\" />"),
    PILLS(
        "pills",
        "<path d=\"M3 8a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M13 17a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M4.5 4.5l7 7\" />\n  <path d=\"M19.5 14.5l-5 5\" />"),
    PLUNGER(
        "plunger",
        "<path d=\"M12.71 14.12l7.81 -7.82a2 2 0 0 0 -2.82 -2.82l-7.82 7.81\" />\n  <path d=\"M3.71 13.22l.7 -.71a5 5 0 0 1 7.08 0a5 5 0 0 1 0 7.08l-.71 .7\" />\n  <path d=\"M3 12.5l8.5 8.5\" />"),
    PRESCRIPTION(
        "prescription",
        "<path d=\"M6 19v-16h4.5a4.5 4.5 0 1 1 0 9h-4.5\" />\n  <path d=\"M19 21l-9 -9\" />\n  <path d=\"M13 21l6 -6\" />"),
    RAZOR(
        "razor",
        "<path d=\"M7 3h10v4h-10l0 -4\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M12 11a2 2 0 0 1 2 2v6a2 2 0 1 1 -4 0v-6a2 2 0 0 1 2 -2\" />"),
    RAZOR_ELECTRIC(
        "razor-electric",
        "<path d=\"M8 3v2\" />\n  <path d=\"M12 3v2\" />\n  <path d=\"M16 3v2\" />\n  <path d=\"M9 12v6a3 3 0 0 0 6 0v-6h-6\" />\n  <path d=\"M8 5h8l-1 4h-6l-1 -4\" />\n  <path d=\"M12 17v1\" />"),
    SKULL(
        "skull",
        "<path d=\"M12 4c4.418 0 8 3.358 8 7.5c0 1.901 -.755 3.637 -2 4.96l0 2.54a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1v-2.54c-1.245 -1.322 -2 -3.058 -2 -4.96c0 -4.142 3.582 -7.5 8 -7.5\" />\n  <path d=\"M10 17v3\" />\n  <path d=\"M14 17v3\" />\n  <path d=\"M8 11a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M14 11a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    SMOKING(
        "smoking",
        "<path d=\"M3 14a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M8 13l0 4\" />\n  <path d=\"M16 5v.5a2 2 0 0 0 2 2a2 2 0 0 1 2 2v.5\" />"),
    SMOKING_NO(
        "smoking-no",
        "<path d=\"M8 13l0 4\" />\n  <path d=\"M16 5v.5a2 2 0 0 0 2 2a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M17 13h3a1 1 0 0 1 1 1v2c0 .28 -.115 .533 -.3 .714m-3.7 .286h-13a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1h9\" />"),
    STETHOSCOPE(
        "stethoscope",
        "<path d=\"M6 4h-1a2 2 0 0 0 -2 2v3.5a5.5 5.5 0 0 0 11 0v-3.5a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M8 15a6 6 0 1 0 12 0v-3\" />\n  <path d=\"M11 3v2\" />\n  <path d=\"M6 3v2\" />\n  <path d=\"M18 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    STETHOSCOPE_OFF(
        "stethoscope-off",
        "<path d=\"M4.172 4.179a2 2 0 0 0 -1.172 1.821v3.5a5.5 5.5 0 0 0 9.856 3.358m1.144 -2.858v-4a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M8 15a6 6 0 0 0 10.714 3.712m1.216 -2.798c.046 -.3 .07 -.605 .07 -.914v-3\" />\n  <path d=\"M11 3v2\" />\n  <path d=\"M18 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 3l18 18\" />"),
    SUNGLASSES(
        "sunglasses",
        "<path d=\"M8 4h-2l-3 10\" />\n  <path d=\"M16 4h2l3 10\" />\n  <path d=\"M10 16h4\" />\n  <path d=\"M21 16.5a3.5 3.5 0 0 1 -7 0v-2.5h7v2.5\" />\n  <path d=\"M10 16.5a3.5 3.5 0 0 1 -7 0v-2.5h7v2.5\" />\n  <path d=\"M4 14l4.5 4.5\" />\n  <path d=\"M15 14l4.5 4.5\" />"),
    THERMOMETER(
        "thermometer",
        "<path d=\"M19 5a2.828 2.828 0 0 1 0 4l-8 8h-4v-4l8 -8a2.828 2.828 0 0 1 4 0\" />\n  <path d=\"M16 7l-1.5 -1.5\" />\n  <path d=\"M13 10l-1.5 -1.5\" />\n  <path d=\"M10 13l-1.5 -1.5\" />\n  <path d=\"M7 17l-3 3\" />"),
    VACCINE(
        "vaccine",
        "<path d=\"M17 3l4 4\" />\n  <path d=\"M19 5l-4.5 4.5\" />\n  <path d=\"M11.5 6.5l6 6\" />\n  <path d=\"M16.5 11.5l-6.5 6.5h-4v-4l6.5 -6.5\" />\n  <path d=\"M7.5 12.5l1.5 1.5\" />\n  <path d=\"M10.5 9.5l1.5 1.5\" />\n  <path d=\"M3 21l3 -3\" />"),
    VACCINE_BOTTLE(
        "vaccine-bottle",
        "<path d=\"M9 4a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -1\" />\n  <path d=\"M10 6v.98c0 .877 -.634 1.626 -1.5 1.77c-.866 .144 -1.5 .893 -1.5 1.77v8.48a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-8.48c0 -.877 -.634 -1.626 -1.5 -1.77a1.795 1.795 0 0 1 -1.5 -1.77v-.98\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 18h10\" />\n  <path d=\"M11 15h2\" />"),
    VACCINE_BOTTLE_OFF(
        "vaccine-bottle-off",
        "<path d=\"M9 5v-1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-4\" />\n  <path d=\"M8.7 8.705a1.806 1.806 0 0 1 -.2 .045c-.866 .144 -1.5 .893 -1.5 1.77v8.48a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-2m0 -4v-2.48c0 -.877 -.634 -1.626 -1.5 -1.77a1.795 1.795 0 0 1 -1.5 -1.77v-.98\" />\n  <path d=\"M7 12h5m4 0h1\" />\n  <path d=\"M7 18h10\" />\n  <path d=\"M11 15h2\" />\n  <path d=\"M3 3l18 18\" />"),
    VACCINE_OFF(
        "vaccine-off",
        "<path d=\"M17 3l4 4\" />\n  <path d=\"M19 5l-4.5 4.5\" />\n  <path d=\"M11.5 6.5l6 6\" />\n  <path d=\"M16.5 11.5l-.5 .5m-2 2l-4 4h-4v-4l4 -4m2 -2l.5 -.5\" />\n  <path d=\"M7.5 12.5l1.5 1.5\" />\n  <path d=\"M3 21l3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    VIRUS(
        "virus",
        "<path d=\"M7 12a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M12 7v-4\" />\n  <path d=\"M11 3h2\" />\n  <path d=\"M15.536 8.464l2.828 -2.828\" />\n  <path d=\"M17.657 4.929l1.414 1.414\" />\n  <path d=\"M17 12h4\" />\n  <path d=\"M21 11v2\" />\n  <path d=\"M15.535 15.536l2.829 2.828\" />\n  <path d=\"M19.071 17.657l-1.414 1.414\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M13 21h-2\" />\n  <path d=\"M8.465 15.536l-2.829 2.828\" />\n  <path d=\"M6.343 19.071l-1.413 -1.414\" />\n  <path d=\"M7 12h-4\" />\n  <path d=\"M3 13v-2\" />\n  <path d=\"M8.464 8.464l-2.828 -2.828\" />\n  <path d=\"M4.929 6.343l1.414 -1.413\" />"),
    VIRUS_OFF(
        "virus-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M8.469 8.46a5 5 0 0 0 7.058 7.084\" />\n  <path d=\"M16.913 12.936a5 5 0 0 0 -5.826 -5.853\" />\n  <path d=\"M12 7v-4\" />\n  <path d=\"M11 3h2\" />\n  <path d=\"M15.536 8.464l2.828 -2.828\" />\n  <path d=\"M17.657 4.929l1.414 1.414\" />\n  <path d=\"M17 12h4\" />\n  <path d=\"M21 11v2\" />\n  <path d=\"M18.364 18.363l-.707 .707\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M13 21h-2\" />\n  <path d=\"M8.465 15.536l-2.829 2.828\" />\n  <path d=\"M6.343 19.071l-1.413 -1.414\" />\n  <path d=\"M7 12h-4\" />\n  <path d=\"M3 13v-2\" />\n  <path d=\"M5.636 5.637l-.707 .707\" />"),
    VIRUS_SEARCH(
        "virus-search",
        "<path d=\"M17 12a5 5 0 1 0 -5 5\" />\n  <path d=\"M12 7v-4\" />\n  <path d=\"M11 3h2\" />\n  <path d=\"M15.536 8.464l2.828 -2.828\" />\n  <path d=\"M17.657 4.929l1.414 1.414\" />\n  <path d=\"M17 12h4\" />\n  <path d=\"M21 11v2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M13 21h-2\" />\n  <path d=\"M8.465 15.536l-2.829 2.828\" />\n  <path d=\"M6.343 19.071l-1.413 -1.414\" />\n  <path d=\"M7 12h-4\" />\n  <path d=\"M3 13v-2\" />\n  <path d=\"M8.464 8.464l-2.828 -2.828\" />\n  <path d=\"M4.929 6.343l1.414 -1.413\" />\n  <path d=\"M15 17.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M19.5 19.5l2.5 2.5\" />");

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
    ACCESSIBLE(
        "accessible",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.051 6.844a1 1 0 0 0 -1.152 -.663l-.113 .03l-2.684 .895l-2.684 -.895l-.113 -.03a1 1 0 0 0 -.628 1.884l.109 .044l2.316 .771v.976l-1.832 2.75l-.06 .1a1 1 0 0 0 .237 1.21l.1 .076l.101 .06a1 1 0 0 0 1.21 -.237l.076 -.1l1.168 -1.752l1.168 1.752l.07 .093a1 1 0 0 0 1.653 -1.102l-.059 -.1l-1.832 -2.75v-.977l2.316 -.771l.109 -.044a1 1 0 0 0 .524 -1.221zm-3.949 -4.184a1.5 1.5 0 1 0 0 3a1.5 1.5 0 0 0 0 -3\" />"),
    BABY_CARRIAGE(
        "baby-carriage",
        "<path d=\"M14.5 2a6.5 6.5 0 0 1 6.49 6.858a1.04 1.04 0 0 1 -.04 .456a6.51 6.51 0 0 1 -3.757 5.103l.532 1.595q .135 -.012 .275 -.012a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 .894 -1.966l-.634 -1.903q -.377 .045 -.765 .045h-2.675q -.547 0 -1.076 -.083l-.648 1.941a3 3 0 1 1 -5.101 2.142l.004 -.176a3 3 0 0 1 3.27 -2.812l.56 -1.682a7 7 0 0 1 -3.652 -4.117l-1.402 -4.213h-1.78a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h2.5a1 1 0 0 1 .949 .684l1.104 3.316h6.447v-5a1 1 0 0 1 1 -1zm-6.5 16a1 1 0 1 0 0 2a1 1 0 0 0 0 -2m10 0a1 1 0 1 0 0 2a1 1 0 0 0 0 -2\" />"),
    BANDAGE(
        "bandage",
        "<path d=\"M20.207 3.793a5.95 5.95 0 0 1 .179 8.228l-.179 .186l-8 8a5.95 5.95 0 0 1 -8.593 -8.228l.179 -.186l8 -8a5.95 5.95 0 0 1 8.414 0zm-8.207 9.207a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm2 -2a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm-4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm2 -2a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883z\" />"),
    EYE_TABLE(
        "eye-table",
        "<path d=\"M20 2a1 1 0 0 1 0 2v16a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-16a1 1 0 1 1 0 -2zm-12 15l-.128 .007a1 1 0 0 0 .118 1.993l.128 -.007a1 1 0 0 0 -.118 -1.993m4 0l-.128 .007a1 1 0 0 0 .118 1.993l.128 -.007a1 1 0 0 0 -.118 -1.993m4 0l-.128 .007a1 1 0 0 0 .118 1.993l.128 -.007a1 1 0 0 0 -.118 -1.993m-6 -3h-1a1 1 0 0 0 0 2h1a1 1 0 0 0 0 -2m5 0h-1a1 1 0 0 0 0 2h1a1 1 0 0 0 0 -2m-1 -8h-4a1 1 0 1 0 0 2h1v3a1 1 0 0 0 2 0v-3h1a1 1 0 0 0 0 -2\" />"),
    EYEGLASS(
        "eyeglass",
        "<path d=\"M6.5 21a4.5 4.5 0 0 1 -4.5 -4.5v-2.518l.004 -.071l.014 -.103l.018 -.076l3.006 -10.02a1 1 0 0 1 .958 -.712h2a1 1 0 1 1 0 2h-1.257l-2.4 8h5.657a1 1 0 0 1 1 1v1h2v-1a1 1 0 0 1 1 -1h5.656l-2.4 -8h-1.256a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h2a1 1 0 0 1 .958 .713l3.01 10.036l.022 .112l.008 .08l.002 2.559a4.5 4.5 0 0 1 -8.972 .5h-2.056a4.5 4.5 0 0 1 -4.472 4\" />"),
    EYEGLASS_2(
        "eyeglass-2",
        "<path d=\"M8 3a1 1 0 1 1 0 2h-1.257l-2.24 7.467a4.5 4.5 0 0 1 6.24 2.533h2.513a4.502 4.502 0 0 1 6.241 -2.534l-2.241 -7.466h-1.256a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h2a1 1 0 0 1 .958 .713l3 10a1 1 0 0 1 .042 .287v2.5a4.5 4.5 0 0 1 -8.972 .5h-2.056a4.5 4.5 0 0 1 -8.972 -.5v-2.5a1 1 0 0 1 .042 -.287l3 -10a1 1 0 0 1 .958 -.713z\" />"),
    FACE_MASK(
        "face-mask",
        "<path d=\"M12.825 4.196l5 1.43a3 3 0 0 1 2.175 2.884v.065c1.7 .33 3 1.72 3 3.425s-1.3 3.095 -3 3.425v.066a3 3 0 0 1 -2.175 2.885l-5 1.428a3 3 0 0 1 -1.65 0l-5 -1.429a3 3 0 0 1 -2.17 -2.702l-.005 -.247c-1.7 -.33 -3 -1.72 -3 -3.426c0 -1.705 1.3 -3.096 3 -3.426v-.064a3 3 0 0 1 2.175 -2.884l5 -1.428a3 3 0 0 1 1.65 0m2.175 8.802h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m-11 -2.349c-.6 .248 -1 .77 -1 1.349c0 .578 .4 1.101 1 1.349zm16.001 0v2.697c.599 -.248 .999 -.77 .999 -1.348s-.4 -1.1 -.999 -1.348m-5.001 -1.652h-6a1 1 0 1 0 0 2h6a1 1 0 0 0 0 -2\" />"),
    FLASK(
        "flask",
        "<path d=\"M15 2a1 1 0 0 1 0 2v4.826l3.932 10.814l.034 .077a1.7 1.7 0 0 1 -.002 1.193l-.07 .162a1.7 1.7 0 0 1 -1.213 .911l-.181 .017h-11l-.181 -.017a1.7 1.7 0 0 1 -1.285 -2.266l.039 -.09l3.927 -10.804v-4.823a1 1 0 1 1 0 -2h6zm-2 2h-2v4h2v-4z\" />"),
    FLASK_2(
        "flask-2",
        "<path d=\"M15 2a1 1 0 0 1 0 2v5.674l.062 .03a7 7 0 0 1 3.85 5.174l.037 .262a7 7 0 0 1 -3.078 6.693a1 1 0 0 1 -.553 .167h-6.635a1 1 0 0 1 -.552 -.166a7 7 0 0 1 .807 -12.134l.062 -.028v-5.672a1 1 0 1 1 0 -2h6zm-2 2h-2v6.34a1 1 0 0 1 -.551 .894l-.116 .049a5 5 0 0 0 -2.92 2.717h9.172a5 5 0 0 0 -2.918 -2.715a1 1 0 0 1 -.667 -.943v-6.342z\" />"),
    HEART_BROKEN(
        "heart-broken",
        "<path d=\"M11.001 3.8l-.001 1.963l-1.894 3.79l-.047 .11a1 1 0 0 0 .341 1.137l3.332 2.499l-1.626 3.254a1 1 0 0 0 -.106 .447v3.417l-7.197 -7.127a6 6 0 0 1 6.956 -9.621zm5.77 -.739l.246 .037a6 6 0 0 1 3.184 10.193l-.044 .037l-7.157 7.088v-3.181l1.894 -3.788l.047 -.11a1 1 0 0 0 -.341 -1.137l-3.333 -2.5l1.627 -3.253a1 1 0 0 0 .106 -.447v-2.187a6 6 0 0 1 3.77 -.752\" />"),
    HOSPITAL_CIRCLE(
        "hospital-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -20 0l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72m2 5a1 1 0 0 0 -1 1v2.999h-2v-2.999a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v8a1 1 0 0 0 2 0v-3.001h2v3.001a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-8a1 1 0 0 0 -1 -1\" />"),
    LUNGS(
        "lungs",
        "<path d=\"M12 3a1 1 0 0 1 1 1v5a2 2 0 0 0 1 1.732v-3.475c0 -1.242 .995 -2.257 2.233 -2.257c.372 0 .738 .094 1.122 .307l.18 .117c1.695 1.23 2.76 3.035 3.773 6.34q .674 2.204 .692 5.06c.016 2.195 -1.657 4.024 -3.843 4.168l-.237 .008c-2.17 0 -3.92 -1.787 -3.92 -3.98v-4.146a4 4 0 0 1 -1.893 -1.112l-.107 -.118l-.107 .118a4 4 0 0 1 -1.892 1.112l-.001 4.146c0 2.193 -1.75 3.98 -3.919 3.98l-.268 -.01c-2.155 -.142 -3.827 -1.971 -3.811 -4.165q .018 -2.858 .692 -5.06c1.011 -3.307 2.076 -5.112 3.822 -6.375l.188 -.117a2.2 2.2 0 0 1 1.064 -.273c1.237 0 2.232 1.015 2.232 2.257l.001 3.475a2 2 0 0 0 .999 -1.732v-5a1 1 0 0 1 1 -1\" />"),
    MICROSCOPE(
        "microscope",
        "<path d=\"M15.707 4.293l3 3a1 1 0 0 1 0 1.414l-1.553 1.555a7 7 0 0 1 -.256 9.74l2.102 -.002a1 1 0 0 1 0 2h-14a1 1 0 0 1 0 -2h1v-1a1 1 0 0 1 0 -2h2a1 1 0 0 1 0 2v1h4a5 5 0 0 0 3.737 -8.323l-3.03 3.03a1 1 0 0 1 -1.414 0l-.793 -.792l-.793 .792a1 1 0 1 1 -1.414 -1.414l.792 -.793l-.792 -.793a1 1 0 0 1 0 -1.414l6 -6a1 1 0 0 1 1.414 0m2 -2l3 3a1 1 0 1 1 -1.414 1.414l-3 -3a1 1 0 1 1 1.414 -1.414\" />"),
    NURSE(
        "nurse",
        "<path d=\"M12.002 4c2.866 0 6.7 1.365 9.532 3.155a1 1 0 0 1 .45 1.024l-2 11a1 1 0 0 1 -.984 .821h-14a1 1 0 0 1 -.984 -.821l-2 -11a1 1 0 0 1 .45 -1.024c2.834 -1.792 6.724 -3.16 9.536 -3.155m-.002 5a1 1 0 0 0 -1 1v1h-1a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 0 1 1h1v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-1h1a1 1 0 0 0 .993 -.883l.007 -.117a1 1 0 0 0 -1 -1h-1v-1a1 1 0 0 0 -.883 -.993z\" />"),
    PILL(
        "pill",
        "<path d=\"M20.207 3.793a5.95 5.95 0 0 1 0 8.414l-8 8a5.95 5.95 0 0 1 -8.414 -8.414l8 -8a5.95 5.95 0 0 1 8.414 0m-7 1.414l-4.294 4.293l5.586 5.586l4.294 -4.292a3.95 3.95 0 1 0 -5.586 -5.586\" />"),
    SUNGLASSES(
        "sunglasses",
        "<path d=\"M8 3a1 1 0 1 1 0 2h-1.257l-2.4 8h5.657a1 1 0 0 1 1 1v1h2v-1a1 1 0 0 1 1 -1h5.656l-2.4 -8h-1.256a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h2a1 1 0 0 1 .958 .713l3.01 10.036l.022 .112l.008 .08l.002 2.559a4.5 4.5 0 0 1 -8.972 .5h-2.056a4.5 4.5 0 0 1 -8.972 -.5v-2.518l.004 -.071l.014 -.103l.018 -.076l3.006 -10.02a1 1 0 0 1 .958 -.712z\" />");

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

  default TablerIcon accessible() {
    return TablerIcon.create(TablerHealth.OutlineIcon.ACCESSIBLE);
  }

  default TablerIcon accessible_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.ACCESSIBLE_OFF);
  }

  default TablerIcon activity() {
    return TablerIcon.create(TablerHealth.OutlineIcon.ACTIVITY);
  }

  default TablerIcon activity_heartbeat() {
    return TablerIcon.create(TablerHealth.OutlineIcon.ACTIVITY_HEARTBEAT);
  }

  default TablerIcon baby_bottle() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BABY_BOTTLE);
  }

  default TablerIcon baby_carriage() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BABY_CARRIAGE);
  }

  default TablerIcon bandage() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BANDAGE);
  }

  default TablerIcon bandage_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BANDAGE_OFF);
  }

  default TablerIcon blind() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BLIND);
  }

  default TablerIcon braille() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BRAILLE);
  }

  default TablerIcon brain() {
    return TablerIcon.create(TablerHealth.OutlineIcon.BRAIN);
  }

  default TablerIcon cane() {
    return TablerIcon.create(TablerHealth.OutlineIcon.CANE);
  }

  default TablerIcon checkup_list() {
    return TablerIcon.create(TablerHealth.OutlineIcon.CHECKUP_LIST);
  }

  default TablerIcon crutches() {
    return TablerIcon.create(TablerHealth.OutlineIcon.CRUTCHES);
  }

  default TablerIcon crutches_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.CRUTCHES_OFF);
  }

  default TablerIcon deaf() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DEAF);
  }

  default TablerIcon dental() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DENTAL);
  }

  default TablerIcon dental_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DENTAL_OFF);
  }

  default TablerIcon disabled() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DISABLED);
  }

  default TablerIcon disabled_2() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DISABLED_2);
  }

  default TablerIcon disabled_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DISABLED_OFF);
  }

  default TablerIcon dna() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DNA);
  }

  default TablerIcon dna_2() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DNA_2);
  }

  default TablerIcon dna_2_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DNA_2_OFF);
  }

  default TablerIcon dna_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.DNA_OFF);
  }

  default TablerIcon ear() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EAR);
  }

  default TablerIcon ear_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EAR_OFF);
  }

  default TablerIcon emergency_bed() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EMERGENCY_BED);
  }

  default TablerIcon empathize() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EMPATHIZE);
  }

  default TablerIcon empathize_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EMPATHIZE_OFF);
  }

  default TablerIcon eye_bitcoin() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYE_BITCOIN);
  }

  default TablerIcon eye_discount() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYE_DISCOUNT);
  }

  default TablerIcon eye_dotted() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYE_DOTTED);
  }

  default TablerIcon eye_table() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYE_TABLE);
  }

  default TablerIcon eyeglass() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS);
  }

  default TablerIcon eyeglass_2() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS_2);
  }

  default TablerIcon eyeglass_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS_OFF);
  }

  default TablerIcon face_mask() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FACE_MASK);
  }

  default TablerIcon face_mask_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FACE_MASK_OFF);
  }

  default TablerIcon fall() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FALL);
  }

  default TablerIcon fingerprint_scan() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FINGERPRINT_SCAN);
  }

  default TablerIcon first_aid_kit() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FIRST_AID_KIT);
  }

  default TablerIcon first_aid_kit_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FIRST_AID_KIT_OFF);
  }

  default TablerIcon flask() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FLASK);
  }

  default TablerIcon flask_2() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FLASK_2);
  }

  default TablerIcon flask_2_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FLASK_2_OFF);
  }

  default TablerIcon flask_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FLASK_OFF);
  }

  default TablerIcon footsteps() {
    return TablerIcon.create(TablerHealth.OutlineIcon.FOOTSTEPS);
  }

  default TablerIcon hand_sanitizer() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HAND_SANITIZER);
  }

  default TablerIcon heart_bitcoin() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEART_BITCOIN);
  }

  default TablerIcon heart_broken() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEART_BROKEN);
  }

  default TablerIcon heart_discount() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEART_DISCOUNT);
  }

  default TablerIcon heart_handshake() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEART_HANDSHAKE);
  }

  default TablerIcon heart_rate_monitor() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEART_RATE_MONITOR);
  }

  default TablerIcon heartbeat() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HEARTBEAT);
  }

  default TablerIcon hospital() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HOSPITAL);
  }

  default TablerIcon hospital_circle() {
    return TablerIcon.create(TablerHealth.OutlineIcon.HOSPITAL_CIRCLE);
  }

  default TablerIcon lungs() {
    return TablerIcon.create(TablerHealth.OutlineIcon.LUNGS);
  }

  default TablerIcon lungs_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.LUNGS_OFF);
  }

  default TablerIcon massage() {
    return TablerIcon.create(TablerHealth.OutlineIcon.MASSAGE);
  }

  default TablerIcon medicine_syrup() {
    return TablerIcon.create(TablerHealth.OutlineIcon.MEDICINE_SYRUP);
  }

  default TablerIcon microscope() {
    return TablerIcon.create(TablerHealth.OutlineIcon.MICROSCOPE);
  }

  default TablerIcon microscope_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.MICROSCOPE_OFF);
  }

  default TablerIcon nurse() {
    return TablerIcon.create(TablerHealth.OutlineIcon.NURSE);
  }

  default TablerIcon old() {
    return TablerIcon.create(TablerHealth.OutlineIcon.OLD);
  }

  default TablerIcon physiotherapist() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PHYSIOTHERAPIST);
  }

  default TablerIcon pill() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PILL);
  }

  default TablerIcon pill_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PILL_OFF);
  }

  default TablerIcon pills() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PILLS);
  }

  default TablerIcon plunger() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PLUNGER);
  }

  default TablerIcon prescription() {
    return TablerIcon.create(TablerHealth.OutlineIcon.PRESCRIPTION);
  }

  default TablerIcon razor() {
    return TablerIcon.create(TablerHealth.OutlineIcon.RAZOR);
  }

  default TablerIcon razor_electric() {
    return TablerIcon.create(TablerHealth.OutlineIcon.RAZOR_ELECTRIC);
  }

  default TablerIcon skull() {
    return TablerIcon.create(TablerHealth.OutlineIcon.SKULL);
  }

  default TablerIcon smoking() {
    return TablerIcon.create(TablerHealth.OutlineIcon.SMOKING);
  }

  default TablerIcon smoking_no() {
    return TablerIcon.create(TablerHealth.OutlineIcon.SMOKING_NO);
  }

  default TablerIcon stethoscope() {
    return TablerIcon.create(TablerHealth.OutlineIcon.STETHOSCOPE);
  }

  default TablerIcon stethoscope_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.STETHOSCOPE_OFF);
  }

  default TablerIcon sunglasses() {
    return TablerIcon.create(TablerHealth.OutlineIcon.SUNGLASSES);
  }

  default TablerIcon thermometer() {
    return TablerIcon.create(TablerHealth.OutlineIcon.THERMOMETER);
  }

  default TablerIcon vaccine() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VACCINE);
  }

  default TablerIcon vaccine_bottle() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_BOTTLE);
  }

  default TablerIcon vaccine_bottle_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_BOTTLE_OFF);
  }

  default TablerIcon vaccine_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_OFF);
  }

  default TablerIcon virus() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VIRUS);
  }

  default TablerIcon virus_off() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VIRUS_OFF);
  }

  default TablerIcon virus_search() {
    return TablerIcon.create(TablerHealth.OutlineIcon.VIRUS_SEARCH);
  }

  default TablerIcon accessible_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.ACCESSIBLE);
  }

  default TablerIcon baby_carriage_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.BABY_CARRIAGE);
  }

  default TablerIcon bandage_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.BANDAGE);
  }

  default TablerIcon eye_table_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.EYE_TABLE);
  }

  default TablerIcon eyeglass_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.EYEGLASS);
  }

  default TablerIcon eyeglass_2_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.EYEGLASS_2);
  }

  default TablerIcon face_mask_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.FACE_MASK);
  }

  default TablerIcon flask_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.FLASK);
  }

  default TablerIcon flask_2_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.FLASK_2);
  }

  default TablerIcon heart_broken_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.HEART_BROKEN);
  }

  default TablerIcon hospital_circle_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.HOSPITAL_CIRCLE);
  }

  default TablerIcon lungs_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.LUNGS);
  }

  default TablerIcon microscope_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.MICROSCOPE);
  }

  default TablerIcon nurse_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.NURSE);
  }

  default TablerIcon pill_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.PILL);
  }

  default TablerIcon sunglasses_filled() {
    return TablerIcon.create(TablerHealth.FilledIcon.SUNGLASSES);
  }
}
