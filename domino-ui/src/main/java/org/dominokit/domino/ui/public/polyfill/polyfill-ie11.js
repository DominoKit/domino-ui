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
(function (arr) {
    arr.forEach(function (item) {
        if (item.hasOwnProperty('remove')) {
            return;
        }
        Object.defineProperty(item, 'remove', {
            configurable: true,
            enumerable: true,
            writable: true,
            value: function remove() {
                if (this.parentNode !== null)
                    this.parentNode.removeChild(this);
            }
        });
    });
})([Element.prototype, CharacterData.prototype, DocumentType.prototype]);

/**
 * polyfill for document.scrollingElement
 * https://github.com/yangg/scrolling-element
 */
(function () {
    if (document.scrollingElement) {
        return
    }
    var element = null
    function scrollingElement () {
        if (element) {
            return element
        } else if (document.body.scrollTop) {
            // speed up if scrollTop > 0
            return (element = document.body)
        }
        var iframe = document.createElement('iframe')
        iframe.style.height = '1px'
        document.documentElement.appendChild(iframe)
        var doc = iframe.contentWindow.document
        doc.write('<!DOCTYPE html><div style="height:9999em">x</div>')
        doc.close()
        var isCompliant = doc.documentElement.scrollHeight > doc.body.scrollHeight
        iframe.parentNode.removeChild(iframe)
        return (element = isCompliant ? document.documentElement : document.body)
    }
    Object.defineProperty(document, 'scrollingElement', {
        get: scrollingElement
    })
})()