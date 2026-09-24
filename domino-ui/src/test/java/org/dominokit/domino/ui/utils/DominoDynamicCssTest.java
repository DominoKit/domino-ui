/*
 * Copyright © 2019 Dominokit
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
package org.dominokit.domino.ui.utils;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.utils.Domino.*;

import com.google.gwt.junit.client.GWTTestCase;
import elemental2.dom.HTMLStyleElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.PositionCss;

public class DominoDynamicCssTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testPaddingAndMarginFactoriesDelegateToTheDynamicUtilities() {
    assertEquals("dui-p-141px", dui_p_("141px").getCssClass());
    assertEquals("dui-p-x-142rem", dui_p_x_(Unit.rem.of(142)).getCssClass());
    assertEquals("dui-p-t-143px", dui_p_t_("143px").getCssClass());
    assertEquals("dui-p-r-144px", dui_p_r_("144px").getCssClass());
    assertEquals("dui-p-b-145px", dui_p_b_("145px").getCssClass());
    assertEquals("dui-p-l-146px", dui_p_l_("146px").getCssClass());
    assertEquals("dui-p-y-147px", dui_p_y_("147px").getCssClass());
    assertEquals("dui-m-148px", dui_m_("148px").getCssClass());
    assertEquals("dui-m-t-149px", dui_m_t_("149px").getCssClass());
    assertEquals("dui-m-r-150px", dui_m_r_("150px").getCssClass());
    assertEquals("dui-m-b-auto", dui_m_b_("auto").getCssClass());
    assertEquals("dui-m-l-151px", dui_m_l_("151px").getCssClass());
    assertEquals("dui-m-x-152px", dui_m_x_("152px").getCssClass());
    assertEquals("dui-m-y-153rem", dui_m_y_(Unit.rem.of(153)).getCssClass());
  }

  public void testGapSizingAndIndentFactoriesDelegateToTheDynamicUtilities() {
    assertEquals("dui-gap-154px", dui_gap_("154px").getCssClass());
    assertEquals("dui-gap-x-155rem", dui_gap_x_(Unit.rem.of(155)).getCssClass());
    assertEquals("dui-gap-y-156px", dui_gap_y_("156px").getCssClass());
    assertEquals("dui-w-157px", dui_w_("157px").getCssClass());
    assertEquals("dui-h-158rem", dui_h_(Unit.rem.of(158)).getCssClass());
    assertEquals("dui-min-w-159px", dui_min_w_("159px").getCssClass());
    assertEquals("dui-min-h-160px", dui_min_h_("160px").getCssClass());
    assertEquals("dui-max-w-161px", dui_max_w_("161px").getCssClass());
    assertEquals("dui-max-h-162rem", dui_max_h_(Unit.rem.of(162)).getCssClass());
    assertEquals("dui-indent-163px", dui_indent_("163px").getCssClass());
  }

  public void testAdvancedLayoutAndVisualFactoriesDelegateToDynamicUtilities() {
    assertEquals("dui-inset-164px", dui_inset_("164px").getCssClass());
    assertEquals("dui-inset-x-165rem", dui_inset_x_(Unit.rem.of(165)).getCssClass());
    assertEquals("dui-top-166px", dui_top_("166px").getCssClass());
    assertEquals("dui-z-167", dui_z_("167").getCssClass());
    assertEquals("dui-basis-168px", dui_flex_basis_("168px").getCssClass());
    assertEquals("dui-grow-169", dui_grow_("169").getCssClass());
    assertEquals("dui-shrink-170", dui_shrink_("170").getCssClass());
    assertEquals("dui-order-171", dui_order_("171").getCssClass());
    assertTrue(
        dui_grid_cols_("repeat(172, minmax(0, 1fr))")
            .getCssClass()
            .startsWith("dui-grid-cols-dyn-"));
    assertTrue(dui_grid_rows_("minmax(0, 173px)").getCssClass().startsWith("dui-grid-rows-dyn-"));
    assertEquals("dui-auto-cols-174px", dui_auto_cols_("174px").getCssClass());
    assertEquals("dui-auto-rows-175px", dui_auto_rows_("175px").getCssClass());
    assertEquals("dui-border-176px", dui_border_("176px").getCssClass());
    assertEquals("dui-rounded-177px", dui_rounded_("177px").getCssClass());
    assertEquals("dui-outline-178px", dui_outline_("178px").getCssClass());
    assertEquals("dui-outline-offset-179px", dui_outline_offset_("179px").getCssClass());
    assertEquals("dui-font-size-180px", dui_font_size_("180px").getCssClass());
    assertEquals("dui-leading-181px", dui_leading_("181px").getCssClass());
    assertEquals("dui-tracking-182px", dui_tracking_("182px").getCssClass());
    assertEquals("dui-font-weight-183", dui_font_weight_("183").getCssClass());
  }

  public void testIntegerFactoriesDelegateToTheirStringCounterparts() {
    assertEquals(dui_p_(2).getCssClass(), dui_p_("2").getCssClass());
    assertEquals(dui_p_t_(3).getCssClass(), dui_p_t_("3").getCssClass());
    assertEquals(dui_p_r_(4).getCssClass(), dui_p_r_("4").getCssClass());
    assertEquals(dui_p_b_(5).getCssClass(), dui_p_b_("5").getCssClass());
    assertEquals(dui_p_l_(6).getCssClass(), dui_p_l_("6").getCssClass());
    assertEquals(dui_p_x_(7).getCssClass(), dui_p_x_("7").getCssClass());
    assertEquals(dui_p_y_(8).getCssClass(), dui_p_y_("8").getCssClass());
    assertEquals(dui_m_(9).getCssClass(), dui_m_("9").getCssClass());
    assertEquals(dui_m_t_(10).getCssClass(), dui_m_t_("10").getCssClass());
    assertEquals(dui_m_r_(11).getCssClass(), dui_m_r_("11").getCssClass());
    assertEquals(dui_m_b_(12).getCssClass(), dui_m_b_("12").getCssClass());
    assertEquals(dui_m_l_(13).getCssClass(), dui_m_l_("13").getCssClass());
    assertEquals(dui_m_x_(14).getCssClass(), dui_m_x_("14").getCssClass());
    assertEquals(dui_m_y_(15).getCssClass(), dui_m_y_("15").getCssClass());
    assertEquals(dui_gap_(16).getCssClass(), dui_gap_("16").getCssClass());
    assertEquals(dui_gap_x_(17).getCssClass(), dui_gap_x_("17").getCssClass());
    assertEquals(dui_gap_y_(18).getCssClass(), dui_gap_y_("18").getCssClass());
    assertEquals(dui_w_(19).getCssClass(), dui_w_("19").getCssClass());
    assertEquals(dui_h_(20).getCssClass(), dui_h_("20").getCssClass());
    assertEquals(dui_min_w_(21).getCssClass(), dui_min_w_("21").getCssClass());
    assertEquals(dui_min_h_(22).getCssClass(), dui_min_h_("22").getCssClass());
    assertEquals(dui_max_w_(23).getCssClass(), dui_max_w_("23").getCssClass());
    assertEquals(dui_max_h_(24).getCssClass(), dui_max_h_("24").getCssClass());
    assertEquals(dui_indent_(25).getCssClass(), dui_indent_("25").getCssClass());
    assertEquals(dui_inset_(26).getCssClass(), dui_inset_("26").getCssClass());
    assertEquals(dui_inset_x_(27).getCssClass(), dui_inset_x_("27").getCssClass());
    assertEquals(dui_inset_y_(28).getCssClass(), dui_inset_y_("28").getCssClass());
    assertEquals(dui_top_(29).getCssClass(), dui_top_("29").getCssClass());
    assertEquals(dui_right_(30).getCssClass(), dui_right_("30").getCssClass());
    assertEquals(dui_bottom_(31).getCssClass(), dui_bottom_("31").getCssClass());
    assertEquals(dui_left_(32).getCssClass(), dui_left_("32").getCssClass());
    assertEquals(dui_z_(33).getCssClass(), dui_z_("33").getCssClass());
    assertEquals(dui_flex_basis_(34).getCssClass(), dui_flex_basis_("34").getCssClass());
    assertEquals(dui_grow_(35).getCssClass(), dui_grow_("35").getCssClass());
    assertEquals(dui_shrink_(36).getCssClass(), dui_shrink_("36").getCssClass());
    assertEquals(dui_order_(37).getCssClass(), dui_order_("37").getCssClass());
    assertEquals(dui_grid_cols_(38).getCssClass(), dui_grid_cols_("38").getCssClass());
    assertEquals(dui_grid_rows_(39).getCssClass(), dui_grid_rows_("39").getCssClass());
    assertEquals(dui_auto_cols_(40).getCssClass(), dui_auto_cols_("40").getCssClass());
    assertEquals(dui_auto_rows_(41).getCssClass(), dui_auto_rows_("41").getCssClass());
    assertEquals(dui_border_(42).getCssClass(), dui_border_("42").getCssClass());
    assertEquals(dui_border_x_(43).getCssClass(), dui_border_x_("43").getCssClass());
    assertEquals(dui_border_y_(44).getCssClass(), dui_border_y_("44").getCssClass());
    assertEquals(dui_border_t_(45).getCssClass(), dui_border_t_("45").getCssClass());
    assertEquals(dui_border_r_(46).getCssClass(), dui_border_r_("46").getCssClass());
    assertEquals(dui_border_b_(47).getCssClass(), dui_border_b_("47").getCssClass());
    assertEquals(dui_border_l_(48).getCssClass(), dui_border_l_("48").getCssClass());
    assertEquals(dui_rounded_(49).getCssClass(), dui_rounded_("49").getCssClass());
    assertEquals(dui_rounded_t_(50).getCssClass(), dui_rounded_t_("50").getCssClass());
    assertEquals(dui_rounded_r_(51).getCssClass(), dui_rounded_r_("51").getCssClass());
    assertEquals(dui_rounded_b_(52).getCssClass(), dui_rounded_b_("52").getCssClass());
    assertEquals(dui_rounded_l_(53).getCssClass(), dui_rounded_l_("53").getCssClass());
    assertEquals(dui_rounded_tl_(54).getCssClass(), dui_rounded_tl_("54").getCssClass());
    assertEquals(dui_rounded_tr_(55).getCssClass(), dui_rounded_tr_("55").getCssClass());
    assertEquals(dui_rounded_br_(56).getCssClass(), dui_rounded_br_("56").getCssClass());
    assertEquals(dui_rounded_bl_(57).getCssClass(), dui_rounded_bl_("57").getCssClass());
    assertEquals(dui_outline_(58).getCssClass(), dui_outline_("58").getCssClass());
    assertEquals(dui_outline_offset_(59).getCssClass(), dui_outline_offset_("59").getCssClass());
    assertEquals(dui_font_size_(60).getCssClass(), dui_font_size_("60").getCssClass());
    assertEquals(dui_leading_(61).getCssClass(), dui_leading_("61").getCssClass());
    assertEquals(dui_tracking_(62).getCssClass(), dui_tracking_("62").getCssClass());
    assertEquals(dui_font_weight_(63).getCssClass(), dui_font_weight_("63").getCssClass());
  }

  public void testMigratedStaticConstantsKeepTheirClassNamesAfterStaticCssRemoval() {
    assertEquals("dui-p-4", dui_p_4.getCssClass());
    assertEquals("dui-m-x-auto", dui_m_x_auto.getCssClass());
    assertEquals("dui-gap-y-3", dui_gap_y_3.getCssClass());
    assertEquals("dui-w-full", dui_w_full.getCssClass());
    assertEquals("dui-basis-1_2p", dui_flex_basis_1_2p.getCssClass());
    assertEquals("dui-inset-y-4", PositionCss.dui_inset_y_4.getCssClass());
    assertEquals("dui-z-10", dui_z_10.getCssClass());
  }

  @Override
  protected void gwtSetUp() {
    removeDynamicStyleSheet();
    DynamicCss.reset();
  }

  @Override
  protected void gwtTearDown() {
    removeDynamicStyleSheet();
    DynamicCss.reset();
  }

  private void removeDynamicStyleSheet() {
    HTMLStyleElement styleElement =
        Js.uncheckedCast(document.getElementById(DynamicCssRegistry.STYLE_ELEMENT_ID));
    if (styleElement != null) {
      styleElement.parentNode.removeChild(styleElement);
    }
  }
}
