import org.apache.beam.sdk.options.PipelineOptions;

public interface MyOptions extends PipelineOptions {
    String getMyCustomOption();
    void setMyCustomOption(String myCustomOption);
}


