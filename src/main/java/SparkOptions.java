import org.apache.beam.runners.spark.SparkPipelineOptions;
import org.apache.beam.sdk.PipelineRunner;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.transforms.display.DisplayData;

import java.util.Map;

public class SparkOptions {
    public static SparkPipelineOptions sp = new SparkPipelineOptions() {
        @Override
        public String getSparkMaster() {
            return "local[2]";
        }

        @Override
        public void setSparkMaster(String s) {

        }

        @Override
        public Long getBatchIntervalMillis() {
            return null;
        }

        @Override
        public void setBatchIntervalMillis(Long aLong) {

        }

        @Override
        public String getStorageLevel() {
            return null;
        }

        @Override
        public void setStorageLevel(String s) {

        }

        @Override
        public Long getMinReadTimeMillis() {
            return null;
        }

        @Override
        public void setMinReadTimeMillis(Long aLong) {

        }

        @Override
        public Long getMaxRecordsPerBatch() {
            return null;
        }

        @Override
        public void setMaxRecordsPerBatch(Long aLong) {

        }

        @Override
        public Double getReadTimePercentage() {
            return null;
        }

        @Override
        public void setReadTimePercentage(Double aDouble) {

        }

        @Override
        public String getCheckpointDir() {
            return null;
        }

        @Override
        public void setCheckpointDir(String s) {

        }

        @Override
        public Long getCheckpointDurationMillis() {
            return null;
        }

        @Override
        public void setCheckpointDurationMillis(Long aLong) {

        }

        @Override
        public Boolean getEnableSparkMetricSinks() {
            return null;
        }

        @Override
        public void setEnableSparkMetricSinks(Boolean aBoolean) {

        }

        @Override
        public boolean getUsesProvidedSparkContext() {
            return false;
        }

        @Override
        public void setUsesProvidedSparkContext(boolean b) {

        }

        @Override
        public boolean isStreaming() {
            return false;
        }

        @Override
        public void setStreaming(boolean b) {

        }

        @Override
        public String getAppName() {
            return "example-save-rdd";
        }

        @Override
        public void setAppName(String s) {

        }

        @Override
        public <T extends PipelineOptions> T as(Class<T> aClass) {
            return null;
        }

        @Override
        public Class<? extends PipelineRunner<?>> getRunner() {
            return null;
        }

        @Override
        public void setRunner(Class<? extends PipelineRunner<?>> aClass) {

        }

        @Override
        public CheckEnabled getStableUniqueNames() {
            return null;
        }

        @Override
        public void setStableUniqueNames(CheckEnabled checkEnabled) {

        }

        @Override
        public String getTempLocation() {
            return null;
        }

        @Override
        public void setTempLocation(String s) {

        }

        @Override
        public String getJobName() {
            return null;
        }

        @Override
        public void setJobName(String s) {

        }

        @Override
        public Map<String, Map<String, Object>> outputRuntimeOptions() {
            return null;
        }

        @Override
        public long getOptionsId() {
            return 0;
        }

        @Override
        public void setOptionsId(long l) {

        }

        @Override
        public void populateDisplayData(DisplayData.Builder builder) {

        }
    };
}
