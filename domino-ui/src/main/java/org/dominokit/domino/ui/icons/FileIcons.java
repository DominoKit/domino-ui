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
package org.dominokit.domino.ui.icons;

public interface FileIcons {

  default Icon attachment() {
    return Icon.create("attachment");
  }

  default Icon cloud() {
    return Icon.create("cloud");
  }

  default Icon cloud_circle() {
    return Icon.create("cloud_circle");
  }

  default Icon cloud_done() {
    return Icon.create("cloud_done");
  }

  default Icon cloud_download() {
    return Icon.create("cloud_download");
  }

  default Icon cloud_off() {
    return Icon.create("cloud_off");
  }

  default Icon cloud_queue() {
    return Icon.create("cloud_queue");
  }

  default Icon cloud_upload() {
    return Icon.create("cloud_upload");
  }

  default Icon create_new_folder() {
    return Icon.create("create_new_folder");
  }

  default Icon file_download() {
    return Icon.create("file_download");
  }

  default Icon file_upload() {
    return Icon.create("file_upload");
  }

  default Icon folder() {
    return Icon.create("folder");
  }

  default Icon folder_open() {
    return Icon.create("folder_open");
  }

  default Icon folder_shared() {
    return Icon.create("folder_shared");
  }
}
