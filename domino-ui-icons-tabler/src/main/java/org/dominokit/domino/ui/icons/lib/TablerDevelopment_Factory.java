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
import org.dominokit.domino.ui.icons.TablerDevelopment;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Development category. */
public final class TablerDevelopment_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerDevelopment tagIcons = new TablerDevelopment() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("a-b", "TablerIcons.a_b()", tagIcons::a_b));
    icons.add(new IconCatalogEntry<>("ai", "TablerIcons.ai()", tagIcons::ai));
    icons.add(
        new IconCatalogEntry<>("ai-agent", "TablerIcons.ai_agent()", tagIcons::ai_agent));
    icons.add(
        new IconCatalogEntry<>(
            "ai-agents", "TablerIcons.ai_agents()", tagIcons::ai_agents));
    icons.add(
        new IconCatalogEntry<>(
            "ai-gateway", "TablerIcons.ai_gateway()", tagIcons::ai_gateway));
    icons.add(new IconCatalogEntry<>("alt", "TablerIcons.alt()", tagIcons::alt));
    icons.add(new IconCatalogEntry<>("api", "TablerIcons.api()", tagIcons::api));
    icons.add(
        new IconCatalogEntry<>("api-app", "TablerIcons.api_app()", tagIcons::api_app));
    icons.add(
        new IconCatalogEntry<>(
            "api-app-off", "TablerIcons.api_app_off()", tagIcons::api_app_off));
    icons.add(
        new IconCatalogEntry<>("api-book", "TablerIcons.api_book()", tagIcons::api_book));
    icons.add(
        new IconCatalogEntry<>("api-off", "TablerIcons.api_off()", tagIcons::api_off));
    icons.add(new IconCatalogEntry<>("apps", "TablerIcons.apps()", tagIcons::apps));
    icons.add(
        new IconCatalogEntry<>("apps-off", "TablerIcons.apps_off()", tagIcons::apps_off));
    icons.add(
        new IconCatalogEntry<>("assembly", "TablerIcons.assembly()", tagIcons::assembly));
    icons.add(
        new IconCatalogEntry<>(
            "assembly-off", "TablerIcons.assembly_off()", tagIcons::assembly_off));
    icons.add(new IconCatalogEntry<>("asset", "TablerIcons.asset()", tagIcons::asset));
    icons.add(
        new IconCatalogEntry<>("auth-2fa", "TablerIcons.auth_2fa()", tagIcons::auth_2fa));
    icons.add(new IconCatalogEntry<>("bot-id", "TablerIcons.bot_id()", tagIcons::bot_id));
    icons.add(new IconCatalogEntry<>("bug", "TablerIcons.bug()", tagIcons::bug));
    icons.add(
        new IconCatalogEntry<>("bug-off", "TablerIcons.bug_off()", tagIcons::bug_off));
    icons.add(new IconCatalogEntry<>("canary", "TablerIcons.canary()", tagIcons::canary));
    icons.add(
        new IconCatalogEntry<>("code-ai", "TablerIcons.code_ai()", tagIcons::code_ai));
    icons.add(
        new IconCatalogEntry<>(
            "codeblock", "TablerIcons.codeblock()", tagIcons::codeblock));
    icons.add(
        new IconCatalogEntry<>(
            "connection", "TablerIcons.connection()", tagIcons::connection));
    icons.add(
        new IconCatalogEntry<>(
            "firewall-check", "TablerIcons.firewall_check()", tagIcons::firewall_check));
    icons.add(
        new IconCatalogEntry<>(
            "firewall-flame", "TablerIcons.firewall_flame()", tagIcons::firewall_flame));
    icons.add(
        new IconCatalogEntry<>(
            "image-generation",
            "TablerIcons.image_generation()",
            tagIcons::image_generation));
    icons.add(new IconCatalogEntry<>("logs", "TablerIcons.logs()", tagIcons::logs));
    icons.add(
        new IconCatalogEntry<>(
            "microfrontends", "TablerIcons.microfrontends()", tagIcons::microfrontends));
    icons.add(
        new IconCatalogEntry<>(
            "middleware", "TablerIcons.middleware()", tagIcons::middleware));
    icons.add(
        new IconCatalogEntry<>("model-ai", "TablerIcons.model_ai()", tagIcons::model_ai));
    icons.add(
        new IconCatalogEntry<>(
            "package-export", "TablerIcons.package_export()", tagIcons::package_export));
    icons.add(
        new IconCatalogEntry<>(
            "package-import", "TablerIcons.package_import()", tagIcons::package_import));
    icons.add(
        new IconCatalogEntry<>("packages", "TablerIcons.packages()", tagIcons::packages));
    icons.add(
        new IconCatalogEntry<>("pipeline", "TablerIcons.pipeline()", tagIcons::pipeline));
    icons.add(
        new IconCatalogEntry<>("play-bug", "TablerIcons.play_bug()", tagIcons::play_bug));
    icons.add(
        new IconCatalogEntry<>(
            "play-bugs", "TablerIcons.play_bugs()", tagIcons::play_bugs));
    icons.add(new IconCatalogEntry<>("prompt", "TablerIcons.prompt()", tagIcons::prompt));
    icons.add(
        new IconCatalogEntry<>(
            "queue-pop-in", "TablerIcons.queue_pop_in()", tagIcons::queue_pop_in));
    icons.add(
        new IconCatalogEntry<>(
            "queue-pop-out", "TablerIcons.queue_pop_out()", tagIcons::queue_pop_out));
    icons.add(
        new IconCatalogEntry<>(
            "scan-traces", "TablerIcons.scan_traces()", tagIcons::scan_traces));
    icons.add(new IconCatalogEntry<>("sdk", "TablerIcons.sdk()", tagIcons::sdk));
    icons.add(new IconCatalogEntry<>("seo", "TablerIcons.seo()", tagIcons::seo));
    icons.add(
        new IconCatalogEntry<>(
            "serverless", "TablerIcons.serverless()", tagIcons::serverless));
    icons.add(
        new IconCatalogEntry<>("sitemap", "TablerIcons.sitemap()", tagIcons::sitemap));
    icons.add(
        new IconCatalogEntry<>(
            "sitemap-off", "TablerIcons.sitemap_off()", tagIcons::sitemap_off));
    icons.add(
        new IconCatalogEntry<>(
            "source-code", "TablerIcons.source_code()", tagIcons::source_code));
    icons.add(
        new IconCatalogEntry<>(
            "terminal-2", "TablerIcons.terminal_2()", tagIcons::terminal_2));
    icons.add(
        new IconCatalogEntry<>(
            "thinking-high", "TablerIcons.thinking_high()", tagIcons::thinking_high));
    icons.add(
        new IconCatalogEntry<>(
            "thinking-low", "TablerIcons.thinking_low()", tagIcons::thinking_low));
    icons.add(
        new IconCatalogEntry<>(
            "thinking-medium",
            "TablerIcons.thinking_medium()",
            tagIcons::thinking_medium));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event", "TablerIcons.timeline_event()", tagIcons::timeline_event));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event-exclamation",
            "TablerIcons.timeline_event_exclamation()",
            tagIcons::timeline_event_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event-minus",
            "TablerIcons.timeline_event_minus()",
            tagIcons::timeline_event_minus));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event-plus",
            "TablerIcons.timeline_event_plus()",
            tagIcons::timeline_event_plus));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event-text",
            "TablerIcons.timeline_event_text()",
            tagIcons::timeline_event_text));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event-x",
            "TablerIcons.timeline_event_x()",
            tagIcons::timeline_event_x));
    icons.add(
        new IconCatalogEntry<>("user-key", "TablerIcons.user_key()", tagIcons::user_key));
    icons.add(
        new IconCatalogEntry<>("versions", "TablerIcons.versions()", tagIcons::versions));
    icons.add(
        new IconCatalogEntry<>(
            "versions-off", "TablerIcons.versions_off()", tagIcons::versions_off));
    icons.add(
        new IconCatalogEntry<>("webhook", "TablerIcons.webhook()", tagIcons::webhook));
    icons.add(
        new IconCatalogEntry<>(
            "webhook-off", "TablerIcons.webhook_off()", tagIcons::webhook_off));
    icons.add(
        new IconCatalogEntry<>(
            "zero-config", "TablerIcons.zero_config()", tagIcons::zero_config));
    icons.add(
        new IconCatalogEntry<>(
            "apps", "TablerIcons.apps_filled()", tagIcons::apps_filled));
    icons.add(
        new IconCatalogEntry<>(
            "assembly", "TablerIcons.assembly_filled()", tagIcons::assembly_filled));
    icons.add(
        new IconCatalogEntry<>(
            "asset", "TablerIcons.asset_filled()", tagIcons::asset_filled));
    icons.add(
        new IconCatalogEntry<>("bug", "TablerIcons.bug_filled()", tagIcons::bug_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sitemap", "TablerIcons.sitemap_filled()", tagIcons::sitemap_filled));
    icons.add(
        new IconCatalogEntry<>(
            "timeline-event",
            "TablerIcons.timeline_event_filled()",
            tagIcons::timeline_event_filled));
    icons.add(
        new IconCatalogEntry<>(
            "versions", "TablerIcons.versions_filled()", tagIcons::versions_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
