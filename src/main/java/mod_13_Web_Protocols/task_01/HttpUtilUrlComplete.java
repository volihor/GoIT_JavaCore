package mod_13_Web_Protocols.task_01;

import java.net.URI;
public class HttpUtilUrlComplete {

    public static URI getAllInPath(String url, String path) {
        return URI.create(url + getSuffix(path));
    }

//    public static URI getUserByUserName(String url, String userName) {
//        return URI.create(url + getByUserName(userName));
//    }

    public static URI buildUri(String baseUrl, String path, String userName) {
        return URI.create(baseUrl + getSuffixUserName(path, userName));
    }
    public static URI buildUri(String baseUrl, String path) {
        return URI.create(baseUrl + getSuffix(path));
    }
    public static URI buildUri(String baseUrl, String path, int id) {
        return URI.create(baseUrl + getSuffix(path, id));
    }
    public static URI buildUri(String baseUrl, String path1, int id, String path2) {
        return URI.create(baseUrl + getSuffix(path1, id, path2));
    }

    private static String getSuffixUserName(String path, String userName) {return "/" + path + "?username=" + userName ; }
    private static String getSuffix(String urlSuffix) {
        return "/" + urlSuffix ;
    }
    private static String getSuffix(String urlSuffix, int id ) { return "/" + urlSuffix + "/" +  id ; }
    private static String getSuffix(String urlSuffix1, int id, String urlSuffix2 ) {
        return "/" + urlSuffix1 + "/" + id + "/" + urlSuffix2 ;
    }
}
