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
package org.dominokit.domino.ui.icons.lib;

import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.MdiIcon;

/**
 * This is a generated class, please don't modify
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class MdiByTagFactory {
  /**
   * get.
   *
   * @param tag a {@link java.lang.String} object
   * @return a {@link java.util.List} object
   */
  public static List<Supplier<MdiIcon>> get(String tag) {
    switch (tag) {
      case MdiTags.DATE_TIME:
        return new Date_Time_Factory().icons();
      case MdiTags.EDIT_MODIFY:
        return new Edit_Modify_Factory().icons();
      case MdiTags.MATH:
        return new Math_Factory().icons();
      case MdiTags.PRINTER:
        return new Printer_Factory().icons();
      case MdiTags.AUTOMOTIVE:
        return new Automotive_Factory().icons();
      case MdiTags.ACCOUNT_USER:
        return new Account_User_Factory().icons();
      case MdiTags.SPORT:
        return new Sport_Factory().icons();
      case MdiTags.CURRENCY:
        return new Currency_Factory().icons();
      case MdiTags.HARDWARE_TOOLS:
        return new Hardware_Tools_Factory().icons();
      case MdiTags.BATTERY:
        return new Battery_Factory().icons();
      case MdiTags.DATABASE:
        return new Database_Factory().icons();
      case MdiTags.VECTOR:
        return new Vector_Factory().icons();
      case MdiTags.SETTINGS:
        return new Settings_Factory().icons();
      case MdiTags.HEALTH_BEAUTY:
        return new Health_Beauty_Factory().icons();
      case MdiTags.ARROW:
        return new Arrow_Factory().icons();
      case MdiTags.GAMING_RPG:
        return new Gaming_RPG_Factory().icons();
      case MdiTags.TRANSPORTATION_FLYING:
        return new Transportation_Flying_Factory().icons();
      case MdiTags.TRANSPORTATION_OTHER:
        return new Transportation_Other_Factory().icons();
      case MdiTags.CLOTHING:
        return new Clothing_Factory().icons();
      case MdiTags.MEDICAL_HOSPITAL:
        return new Medical_Hospital_Factory().icons();
      case MdiTags.BANKING:
        return new Banking_Factory().icons();
      case MdiTags.COLOR:
        return new Color_Factory().icons();
      case MdiTags.TOOLTIP:
        return new Tooltip_Factory().icons();
      case MdiTags.GEOGRAPHICINFORMATIONSYSTEM:
        return new GeographicInformationSystem_Factory().icons();
      case MdiTags.ANIMAL:
        return new Animal_Factory().icons();
      case MdiTags.BRAND_LOGO:
        return new Brand_Logo_Factory().icons();
      case MdiTags.SHAPE:
        return new Shape_Factory().icons();
      case MdiTags.TRANSPORTATION_WATER:
        return new Transportation_Water_Factory().icons();
      case MdiTags.FORM:
        return new Form_Factory().icons();
      case MdiTags.SOCIALMEDIA:
        return new SocialMedia_Factory().icons();
      case MdiTags.SCIENCE:
        return new Science_Factory().icons();
      case MdiTags.VIDEO_MOVIE:
        return new Video_Movie_Factory().icons();
      case MdiTags.NOTIFICATION:
        return new Notification_Factory().icons();
      case MdiTags.PLACES:
        return new Places_Factory().icons();
      case MdiTags.DEVICE_TECH:
        return new Device_Tech_Factory().icons();
      case MdiTags.HOMEAUTOMATION:
        return new HomeAutomation_Factory().icons();
      case MdiTags.ALPHA_NUMERIC:
        return new Alpha_Numeric_Factory().icons();
      case MdiTags.FILES_FOLDERS:
        return new Files_Folders_Factory().icons();
      case MdiTags.EMOJI:
        return new Emoji_Factory().icons();
      case MdiTags.AGRICULTURE:
        return new Agriculture_Factory().icons();
      case MdiTags.DRAWING_ART:
        return new Drawing_Art_Factory().icons();
      case MdiTags.SHOPPING:
        return new Shopping_Factory().icons();
      case MdiTags.TRANSPORTATION_ROAD:
        return new Transportation_Road_Factory().icons();
      case MdiTags.PEOPLE_FAMILY:
        return new People_Family_Factory().icons();
      case MdiTags.CELLPHONE_PHONE:
        return new Cellphone_Phone_Factory().icons();
      case MdiTags.NATURE:
        return new Nature_Factory().icons();
      case MdiTags.TEXT_CONTENT_FORMAT:
        return new Text_Content_Format_Factory().icons();
      case MdiTags.NAVIGATION:
        return new Navigation_Factory().icons();
      case MdiTags.RELIGION:
        return new Religion_Factory().icons();
      case MdiTags.FOOD_DRINK:
        return new Food_Drink_Factory().icons();
      case MdiTags.VIEW:
        return new View_Factory().icons();
      case MdiTags.LOCK:
        return new Lock_Factory().icons();
      case MdiTags.DEVELOPER_LANGUAGES:
        return new Developer_Languages_Factory().icons();
      case MdiTags.WEATHER:
        return new Weather_Factory().icons();
      case MdiTags.PHOTOGRAPHY:
        return new Photography_Factory().icons();
      case MdiTags.HOLIDAY:
        return new Holiday_Factory().icons();
      case MdiTags.MUSIC:
        return new Music_Factory().icons();
      case MdiTags.CLOUD:
        return new Cloud_Factory().icons();
      case MdiTags.ALERT_ERROR:
        return new Alert_Error_Factory().icons();
      case MdiTags.AUDIO:
        return new Audio_Factory().icons();
      case MdiTags.ARRANGE:
        return new Arrange_Factory().icons();
      case MdiTags.UNTAGGED:
        return new UnTagged_Factory().icons();
      default:
        throw new IllegalArgumentException(tag);
    }
  }
}
