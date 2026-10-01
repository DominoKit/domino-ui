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
package org.dominokit.domino.ui.data;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class HasDataFiltersTest {

  @Test
  public void filterCanChangeRegistrationWithoutAbortingCurrentPass() {
    FilterSubject subject = new FilterSubject();
    int[] secondFilterCalls = {0};
    subject.filters.add(
        value -> {
          subject.filters.add(candidate -> true);
          return true;
        });
    subject.filters.add(
        value -> {
          secondFilterCalls[0]++;
          return true;
        });

    assertEquals(java.util.Collections.singletonList("item"), subject.filterData("item"));
    assertEquals(1, secondFilterCalls[0]);
  }

  private static class FilterSubject implements HasDataFilters<String, FilterSubject> {
    private final Set<DataFilter<? super String>> filters = new LinkedHashSet<>();
    private boolean paused;

    @Override
    public FilterSubject pauseDataFilters() {
      paused = true;
      return this;
    }

    @Override
    public FilterSubject resumeDataFilters() {
      paused = false;
      return this;
    }

    @Override
    public FilterSubject togglePauseDataFilters(boolean toggle) {
      paused = toggle;
      return this;
    }

    @Override
    public Set<DataFilter<? super String>> getDataFilters() {
      return filters;
    }

    @Override
    public boolean isDataFiltersPaused() {
      return paused;
    }
  }
}
