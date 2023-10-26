/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.siddhi.extension.io.file.metrics;

import org.wso2.carbon.metrics.core.Level;
import org.wso2.carbon.si.metrics.core.internal.MetricsDataHolder;

/**
 * Class which is holds the metrics to monitor rename file operations.
 */
public class FileRenameMetrics extends Metrics {

    private String source;
    private long time;

    public FileRenameMetrics(String siddhiAppName) {
        super(siddhiAppName);
    }

    public void getRenameMetric(int status) {
        MetricsDataHolder.getInstance().getMetricService()
                .gauge(String.format("io.siddhi.SiddhiApps.%s.Siddhi.File.Operations.Rename.%s.%s",
                        siddhiAppName, time + ".time", source + ".source"), Level.INFO, () -> status);
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
