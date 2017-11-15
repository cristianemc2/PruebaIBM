package osb.rest.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.json.JSONObject;

import osb.rest.common.exception.PortobellaException;

public class CommonUtil {

    /**
     * Método para castear un Objeto JSON a un String.
     * 
     * @param objectJSON
     * @return
     * @throws PortobellaException
     */
    public static String castJSONToString(Object objectJSON)
            throws PortobellaException {

        try {

            Map<String, String> objectMap;
            JSONObject jsonObj;

            if (objectJSON instanceof Map) {
                objectMap = (Map<String, String>) objectJSON;
                jsonObj = new JSONObject(objectMap);
            } else {
                jsonObj = new JSONObject(objectJSON);
            }

            return jsonObj.toString();

        } catch (Exception e) {

            throw new PortobellaException(e);
        }

    }

    /**
     * Metodo que concatena un vector de String.
     * 
     * @param vectorString
     * @return
     */
    public static String buildString(String... vectorString) {

        StringBuilder sb = new StringBuilder();

        for (String str : vectorString) {
            sb.append(str);
        }

        return sb.toString();

    }

    /**
     * Metodo que convierte una fecha string a un formato especifico
     * 
     * @param date
     * @param formatSource
     * @param formatTarget
     * @return
     * @throws PortobellaException
     */
    public static String formatDateStringToString(String date,
            String formatSource, String formatTarget)
            throws PortobellaException {

        try {

            if (null != date) {
                SimpleDateFormat simpleDateFormatSource = new SimpleDateFormat(
                        formatSource);
                Date d1 = simpleDateFormatSource.parse(date);

                SimpleDateFormat simpleDateFormatTarget = new SimpleDateFormat(
                        formatTarget);
                return simpleDateFormatTarget.format(d1);
            }
        } catch (Exception e) {
            throw new PortobellaException(e);
        }
        return Constant.COMMON_STRING_EMPTY;
    }

}
