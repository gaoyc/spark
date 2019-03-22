package org.apache.spark.launcher;

/**
 * Created by kigo on 2019/2/27 0027.
 */
public class MainTest {

    public static void main(String[] args) {
        try {
            // env args
//            JAVA_HOME C:/Java/jdk1.8.0_45
//            SPARK_HOME D:/tools/dev/bigData/spark-2.1.0-bin-hadoop2.7
//            SPARK_SCALA_VERSION 2.11
//            SPARK_PRINT_LAUNCH_COMMAND

            // programe args
//            org.apache.spark.deploy.SparkSubmit --class org.apache.carbondata.spark.thriftserver.CarbonThriftServer --master spark://cabondata1:7077 --driver-memory 16g --executor-memory 32g --executor-cores 24 --name Thrift-JDBC/ODBC-Server

            Main.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
