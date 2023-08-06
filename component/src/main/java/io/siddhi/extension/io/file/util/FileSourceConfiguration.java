/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package io.siddhi.extension.io.file.util;

import org.quartz.Scheduler;
import org.wso2.transport.file.connector.server.FileServerConnector;
import org.wso2.transport.remotefilesystem.server.connector.contract.RemoteFileSystemServerConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/**
 * Class for keep the configurations of a file source instance.
 */
public class FileSourceConfiguration {

    private boolean isTailingEnabled;
    private String mode;
    private String beginRegex = null;
    private String endRegex = null;
    private String filePointer = "0";
    private String filePollingInterval = null;
    private String sourceProtocol = null;
    private String protocolForMoveAfterFailure = null;
    private String protocolForMoveAfterProcess = null;
    private long timeout = 5000;
    private String headerPresent = "false";
    private int headerLineCount = 1;
    private String readOnlyHeader = "false";
    private String readOnlyTrailer = "false";
    private String skipTrailer = "false";
    private String bufferSizeInBinaryChunked = "65536";

    private FileServerConnector fileServerConnector;
    private RemoteFileSystemServerConnector fileSystemServerConnector;
    private List<String> processedFileList = new ArrayList<>();
    private List<String> tailedFileURIMap;
    private ExecutorService executorService = null;
    private String[] requiredProperties = null;
    private StringBuilder tailingRegexStringBuilder = null;
    private Pattern pattern;

    private String actionAfterProcess = null;
    private String moveIfExistMode = null;
    private String actionAfterFailure = null;
    private String moveAfterProcess = null;
    private String fileReadWaitTimeout;
    private String cronExpression = null;
    private String uri = null;
    private Scheduler scheduler = null;

    private String currentlyReadingFileURI;
    // once app is disconnected

    public FileSourceConfiguration() {
        tailingRegexStringBuilder = new StringBuilder();
    }

    public String getBeginRegex() {
        return beginRegex;
    }

    public void setBeginRegex(String beginRegex) {
        this.beginRegex = beginRegex;
    }

    public String getEndRegex() {
        return endRegex;
    }

    public void setEndRegex(String endRegex) {
        this.endRegex = endRegex;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isTailingEnabled() {
        return isTailingEnabled;
    }

    public void setTailingEnabled(boolean tailingEnabled) {
        isTailingEnabled = tailingEnabled;
    }

    public String getFilePointer() {
        return filePointer;
    }

    public void setFilePointer(String filePointer) {
        this.filePointer = filePointer;
    }

    public void updateFilePointer(long valueToAdd) {
        this.filePointer = Long.toString(valueToAdd);
    }

    public FileServerConnector getFileServerConnector() {
        return fileServerConnector;
    }

    public void setFileServerConnector(FileServerConnector fileServerConnector) {
        this.fileServerConnector = fileServerConnector;
    }

    public RemoteFileSystemServerConnector getFileSystemServerConnector() {
        return this.fileSystemServerConnector;
    }

    public void setFileSystemServerConnector(RemoteFileSystemServerConnector fileSystemServerConnector) {
        this.fileSystemServerConnector = fileSystemServerConnector;
    }

    public List getTailedFileURIMap() {
        return tailedFileURIMap;
    }

    public void setTailedFileURIMap(List<String> tailedFileURIMap) {
        this.tailedFileURIMap = tailedFileURIMap;
    }

    public void setTailedFileURI(String tailedFileURI) {
        if (tailedFileURI != null) {
            if (tailedFileURIMap == null) {
                tailedFileURIMap = new ArrayList<>();
            }
            if (!tailedFileURIMap.contains(tailedFileURI)) {
                this.tailedFileURIMap.add(tailedFileURI);
            }
        }
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public String[] getRequiredProperties() {
        return requiredProperties.clone();
    }

    public void setRequiredProperties(String[] requiredProperties) {
        this.requiredProperties = requiredProperties.clone();
    }

    public String getFilePollingInterval() {
        return filePollingInterval;
    }

    public void setFilePollingInterval(String filePollingInterval) {
        this.filePollingInterval = filePollingInterval;
    }

    public StringBuilder getTailingRegexStringBuilder() {
        return tailingRegexStringBuilder;
    }

    public void updateTailingRegexStringBuilder(StringBuilder tailingRegexStringBuilder) {
        this.tailingRegexStringBuilder = tailingRegexStringBuilder;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public String getActionAfterProcess() {
        return actionAfterProcess;
    }

    public void setActionAfterProcess(String actionAfterProcess) {
        this.actionAfterProcess = actionAfterProcess;
    }

    public String getMoveAfterProcess() {
        return moveAfterProcess;
    }

    public void setMoveAfterProcess(String moveAfterProcess) {
        this.moveAfterProcess = moveAfterProcess;
    }

    public String getSourceProtocol() {
        return sourceProtocol;
    }

    public void setSourceProtocol(String sourceProtocol) {
        this.sourceProtocol = sourceProtocol;
    }

    public String getProtocolForMoveAfterFailure() {
        return protocolForMoveAfterFailure;
    }

    public void setProtocolForMoveAfterFailure(String protocolForMoveAfterFailure) {
        this.protocolForMoveAfterFailure = protocolForMoveAfterFailure;
    }

    public String getProtocolForMoveAfterProcess() {
        return protocolForMoveAfterProcess;
    }

    public void setProtocolForMoveAfterProcess(String protocolForMoveAfterProcess) {
        this.protocolForMoveAfterProcess = protocolForMoveAfterProcess;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getFileReadWaitTimeout() {
        return fileReadWaitTimeout;
    }

    public void setFileReadWaitTimeout(String fileReadWaitTimeout) {
        this.fileReadWaitTimeout = fileReadWaitTimeout;
    }

    public String getActionAfterFailure() {
        return actionAfterFailure;
    }

    public void setActionAfterFailure(String actionAfterFailure) {
        this.actionAfterFailure = actionAfterFailure;
    }

    public String getHeaderPresent() {
        return headerPresent;
    }

    public void setHeaderPresent(String headerPresent) {
        this.headerPresent = headerPresent;
    }

    public int getHeaderLineCount() {
        return headerLineCount;
    }

    public void setHeaderLineCount(int headerLineCount) {
        this.headerLineCount = headerLineCount;
    }

    public String getCurrentlyReadingFileURI() {
        return currentlyReadingFileURI;
    }

    public void setCurrentlyReadingFileURI(String currentlyReadingFileURI) {
        this.currentlyReadingFileURI = currentlyReadingFileURI;
    }

    public String getReadOnlyHeader() {
        return readOnlyHeader;
    }

    public void setReadOnlyHeader(String readOnlyHeader) {
        this.readOnlyHeader = readOnlyHeader;
    }

    public void setBufferSize(String bufferSizeInBinaryChunked) {
        this.bufferSizeInBinaryChunked = bufferSizeInBinaryChunked;
    }

    public String getBufferSize() {
        return bufferSizeInBinaryChunked;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public List<String> getProcessedFileList() {
        return processedFileList;
    }

    public void setProcessedFileList(List<String> processedFileList) {
        this.processedFileList = processedFileList;
    }

    /**
     * Maintains the processedFileList. Adds a file URL to the list if it has not being added already.
     * @param fileURI the file URI which needs to be added to the list
     * @return true if the fileURI is absent in the current list and adds to it; false if the URI is already present.
     */
    public boolean addFileToListIfAbsent(String fileURI) {
        if (processedFileList.contains(fileURI)) {
            return false;
        }
        processedFileList.add(fileURI);
        return true;
    }

    public String getMoveIfExistMode() {
        return moveIfExistMode;
    }

    public void setMoveIfExistMode(String moveIfExistMode) {
        this.moveIfExistMode = moveIfExistMode;
    }

    public String getReadOnlyTrailer() {
        return readOnlyTrailer;
    }

    public void setReadOnlyTrailer(String readOnlyTrailer) {
        this.readOnlyTrailer = readOnlyTrailer;
    }

    public String getSkipTrailer() {
        return skipTrailer;
    }

    public void setSkipTrailer(String skipTrailer) {
        this.skipTrailer = skipTrailer;
    }
}
