import org.apache.beam.sdk.PipelineRunner;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.transforms.display.DisplayData;

import java.util.Map;

public class MyOptionImple implements MyOptions{

    @Override
    public String getMyCustomOption() {
        return null;
    }

    @Override
    public void setMyCustomOption(String myCustomOption) {

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
}
