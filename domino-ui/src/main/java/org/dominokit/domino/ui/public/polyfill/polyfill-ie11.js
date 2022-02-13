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
    });
})();

/**
 * polyfill for ResizeObserver
 * based on https://codepen.io/dgca/pen/WoJoNB
 */
 (function () {
    if (typeof ResizeObserver !== 'undefined') {
        return;
    }

    window.ResizeObserver = function (callback) {
        this.observables = [];

        this.boundCheck = this.check.bind(this)
        this.callback = callback;
        this.af = 0;
    };

    ResizeObserver.prototype.observe = function (el) {
        if (this.observables.some(function (observable) { observable.el === el })) {
            return;
        }
        const newObservable = {
            el: el,
            size: {
                height: el.clientHeight,
                width: el.clientWidth
            }
        }
        this.observables.push(newObservable);
        if (!this.af) {
            this.boundCheck();
        }
    };

    ResizeObserver.prototype.unobserve = function (el) {
        this.observables = this.observables.filter(function (obj) { obj.el !== el });

        if (!this.observables.length && this.af) {
            window.cancelAnimationFrame(this.af);
            this.af = 0;
        }
    };

    ResizeObserver.prototype.disconnect = function () {
        this.observables = [];
        if (this.af) {
            window.cancelAnimationFrame(this.af);
            this.af = 0;
        }
    };

    ResizeObserver.prototype.check = function () {
        const changedEntries = this.observables
            .filter(function (obj) {
            const currentHeight = obj.el.clientHeight;
            const currentWidth = obj.el.clientWidth;
            if (obj.size.height !== currentHeight || obj.size.width !== currentWidth) {
                obj.size.height = currentHeight;
                obj.size.width = currentWidth;
                return true;
            }
            })
            .map(function (obj) { obj.el });
        if (changedEntries.length > 0) {
            this.callback(changedEntries);
        }
        this.af = window.requestAnimationFrame(this.boundCheck);
    };
})();
