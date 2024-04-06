package com.example.DDDSample.application.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *

 */
public class WriteLog {

    private static final Logger LOG = LoggerFactory.getLogger(WriteLog.class);

    public static void debug(Object message) {
        LOG.debug(message.toString());
    }

    public static void debug(Object transid, Object object) {
        debug("[" + transid + "]---" + object);
    }



    public static void error(Object object, Throwable e) {
        LOG.error(object.toString(), e);

    }

    public static void error(Throwable e) {
        error(e.getMessage(), e);
    }

    public static void error(Object transId, Object object, Throwable e) {
        error("[" + transId + "]---" + object, e);
    }

    public static void error(Object transId, Object object, String message, Throwable e) {
        error(String.format("[%s][%s]", transId, object), message, e);
    }

    public static void error(Object transId, Object object, String process, String message, Throwable e) {
        error(String.format("[%s][%s][%s]", transId, object, process), message, e);
    }
    public static void error(Object transId, Object object1, Object object2, String process, String message, Throwable e) {
        error(String.format("[%s][%s][%s][%s]", transId, object1, object2, process), message, e);
    }

    public static void error(Object transId, Object object1, Object object2, Object object3, String process, String message, Throwable e) {
        error(String.format("[%s][%s][%s][%s][%s]", transId, object1, object2, object3, process), message, e);
    }

    public static void write(Object object) {
        LOG.info(object.toString());
    }

    public static void write(Object transid, Object object) {
        write("[" + transid + "]---" + object);
    }

    public static void write(Object workerName, Object transid, Object object) {
        write("[" + workerName + "]" + "[" + transid + "]", object);
    }

    public static void write(Object transId, Object object, Object object2, Object message) {
        write(String.format("[%s][%s][%s]", transId, object, object2), message);
    }

    public static void write(Object transId, Object object, Object object2, String process, Object message) {
        write(String.format("[%s][%s][%s][%s]", transId, object, object2, process), message);
    }

    public static void write(Object transId, Object object, Object object2, Object object3, String process, Object message) {
        write(String.format("[%s][%s][%s][%s][%s]", transId, object, object2, object3, process), message);
    }

    public static void writeResourceObject(String process, Object object)
    {
        ObjectMapper mapper = new ObjectMapper();
        String json = "N/A";
        try {
            write("-----------" + process);
            json = mapper.writeValueAsString(object);
            write(String.format("[%s][%s]",process,json));
        }
        catch (Exception ex) {
            write(String.format("[%s][%s]",process,ex.toString()));
        }
    }
}
