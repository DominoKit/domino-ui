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

import elemental2.core.ArrayBuffer;
import elemental2.core.Uint8Array;
import elemental2.dom.File;
import elemental2.promise.Promise;
import java.util.ArrayList;
import java.util.List;
import jsinterop.base.Js;

public class FileUtil {

  public static Promise<Uint8Array> fileToUint8Array(File file) {
    return file.arrayBuffer()
        .then(
            buffer -> {
              ArrayBuffer ab = Js.uncheckedCast(buffer);
              return Promise.resolve(new Uint8Array(ab));
            });
  }

  public static Promise<byte[]> fileToByteArray(File file) {
    return fileToUint8Array(file)
        .then(
            jsBytes -> {
              byte[] bytes = new byte[(int) jsBytes.length];
              for (int i = 0; i < jsBytes.length; i++) {
                int value = jsBytes.getAt(i).intValue() & 0xFF;
                bytes[i] = (byte) value;
              }
              return Promise.resolve(bytes);
            });
  }

  public static Promise<List<Uint8Array>> filesToUint8Arrays(List<File> files) {
    return filesToUint8Arrays(files, 0, new ArrayList<>());
  }

  private static Promise<List<Uint8Array>> filesToUint8Arrays(
      List<File> files, int index, List<Uint8Array> result) {
    if (index >= files.size()) {
      return Promise.resolve(result);
    }

    return fileToUint8Array(files.get(index))
        .then(
            bytes -> {
              result.add(bytes);
              return filesToUint8Arrays(files, index + 1, result);
            });
  }

  public static Promise<List<byte[]>> filesToByteArrays(List<File> files) {
    return filesToByteArrays(files, 0, new ArrayList<>());
  }

  private static Promise<List<byte[]>> filesToByteArrays(
      List<File> files, int index, List<byte[]> result) {
    if (index >= files.size()) {
      return Promise.resolve(result);
    }

    return fileToByteArray(files.get(index))
        .then(
            bytes -> {
              result.add(bytes);
              return filesToByteArrays(files, index + 1, result);
            });
  }
}
