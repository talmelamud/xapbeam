import com.gigaspaces.document.SpaceDocument;
import com.j_spaces.core.SpaceConfigFactory;
import org.apache.beam.runners.spark.SparkContextOptions;
import org.apache.beam.runners.spark.SparkRunner;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.io.GenerateSequence;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.DataFrameWriter;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.StructType;
import org.insightedge.examples.basic.Product;
import org.openspaces.core.space.SpaceProxyConfigurer;

import java.io.File;


public class MainBeam {

    public static void main (String []args){

        SpaceProxyConfigurer sp = new SpaceProxyConfigurer("insightedge-space").lookupGroups("insight-edge").lookupLocators("127.0.0.1");
        sp.create();
        //--sparkMaster=local[2] --runner=SparkRunner
       /* conf = SparkConf();
        conf.setAppName("InsightEdge Python Example")
        conf.set("spark.insightedge.space.name", "insightedge-space")
        conf.set("spark.insightedge.space.lookup.group", "insightedge")
        conf.set("spark.insightedge.space.lookup.locator", "127.0.0.1:4174")

        spark = SparkSession.builder.config(conf=SparkConf()).getOrCreate()
*/


        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        //****************
        SparkConf conf = new SparkConf();
        conf.setAppName("InsightEdge Python Example");
        conf.set("spark.insightedge.space.name", "insightedge-space");

        conf.set("spark.insightedge.space.lookup.group", "tal");
        //
        //conf.set("spark.insightedge.space.lookup.locator", "talm-ThinkPad-T470s:4174");
         //conf.set("spark.insightedge.space.lookup.locator", "127.0.0.1:4174");

        //conf.set("spark.insightedge.space.lookup.group", "none");
        //conf.set("spark.insightedge.space.lookup.locator", "none");

        conf.setMaster("spark://localhost:7077");
        conf.set("spark.eventLog.enable","true");
        conf.set("spark.eventLog.dir", "/home/spark-logs");
        ///***********************


        //SparkPipelineOptions options = PipelineOptionsFactory.as(SparkPipelineOptions.class);
        //options.setRunner(SparkRunner.class);
        //options.setSparkMaster("spark://localhost:7077");
        //options.setSparkMaster("local[2]");
        //options.setAppName("example-save-rdd");

        ///**************************
        JavaSparkContext jsc = new JavaSparkContext(conf);
        jsc.addJar("/home/talm/Downloads/gigaspaces-insightedge-1.1.0-SNAPSHOT-premium/datagrid/lib/required/xap-datagrid.jar");
        jsc.addJar("/home/talm/Downloads/gigaspaces-insightedge-1.1.0-SNAPSHOT-premium/lib/insightedge-core-1.1.0-SNAPSHOT.jar");
        jsc.addJar("/home/talm/Downloads/gigaspaces-insightedge-1.1.0-SNAPSHOT-premium/datagrid/lib/required/xap-openspaces.jar");
        File requiredLib = new File("/home/talm/Downloads/gigaspaces-insightedge-1.1.0-SNAPSHOT-premium/datagrid/lib/required");
        for ( File f : requiredLib.listFiles()){
            jsc.addJar(f.getPath());
        }



        SparkContextOptions optionsSpark = PipelineOptionsFactory.as(SparkContextOptions.class);
        optionsSpark.setRunner(SparkRunner.class);
        optionsSpark.setUsesProvidedSparkContext(true);
        optionsSpark.setProvidedSparkContext(jsc);
        //optionsSpark.setSparkMaster("spark://localhost:7077");
        optionsSpark.setAppName("InsightEdge Python Example");

        SQLContext sqlContext = new SQLContext(jsc);
       sqlContext.getOrCreate(JavaSparkContext.toSparkContext(jsc));


        JavaRDD<String> javaRdd = jsc.textFile("/home/talm/Downloads/tmp/README.md");
        DataFrame df = sqlContext.createDataFrame(javaRdd, StructType.class);

        DataFrameWriter a = df.write().format("org.apache.spark.sql.insightedge").mode("overwrite");
        a.save("tal");




        Pipeline pipeline = Pipeline.create(optionsSpark);
        //final Pipeline pipeline = Pipeline.create(PipelineOptionsFactory.fromArgs(args).withValidation().create());

        pipeline.getCoderRegistry().registerCoderForClass(Product.class, SerializableCoder.of(Product.class));






        //DataFrame df = sqlContext.read().format("org.apache.spark.sql.insightedge").




        pipeline.apply(GenerateSequence.from(0).to(100000L))
                .apply(ParDo.of(new DoFn<Long, Product>() {
                    @ProcessElement
                    public void onElement(final ProcessContext context) {
                        final long i = context.element();
                        context.output(new Product(i, "org.insightedge.examples.basic.Product #" + i,5,false));
                        System.out.println(i);

                    }
                }));



        pipeline.run();
    }
}
