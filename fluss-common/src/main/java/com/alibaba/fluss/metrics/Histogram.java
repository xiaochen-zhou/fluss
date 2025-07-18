/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.fluss.metrics;

import com.alibaba.fluss.annotation.PublicEvolving;

/**
 * Histogram interface to be used with Fluss's metrics system.
 *
 * <p>The histogram allows to record values, get the current count of recorded values and create
 * histogram statistics for the currently seen elements.
 *
 * @since 0.2
 */
@PublicEvolving
public interface Histogram extends Metric {

    /**
     * Update the histogram with the given value.
     *
     * @param value Value to update the histogram with
     */
    void update(long value);

    /**
     * Get the count of seen elements.
     *
     * @return Count of seen elements
     */
    long getCount();

    /**
     * Create statistics for the currently recorded elements.
     *
     * @return Statistics about the currently recorded elements
     */
    HistogramStatistics getStatistics();

    @Override
    default MetricType getMetricType() {
        return MetricType.HISTOGRAM;
    }
}
