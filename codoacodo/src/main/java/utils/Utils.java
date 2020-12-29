package utils;

import java.util.List;

// Heroku
public class Utils {
    private final static String home = "web_cac";
    private final static String online = "codoacodo.herokuapp.com";
    private final static String index = "index.jsp";
    private final static String html = ".html";
    private final static String jsp = ".jsp";

    public static String toCapitalize(String text){
        String result = "";
        String[] as = text.split(" ");
        for (String a : as) {
            result = result.concat(a.toUpperCase().charAt(0) + a.substring(1) + " ");
        }
        return result;
    }
    
    public static String transformRoutes(String pageNow, String page) {
        String result;
        if(page.equals("sing in")){
            page = "signIn";
        }
        if (pageNow.equals(home) || pageNow.equals(index) || pageNow.equals(online)){
            if (page.equals("index")){
                result = "#";
            }else{
                result = "html/" + page + jsp;
            }
        }else{
            if (page.equals("index")){
                result = "../";
            }else if(activeLink(pageNow, page)){
                result = "#";
            }else{
                result = page + jsp;
            }
        }
        return result;
    }
    
    public static boolean activeLink(String pageNow, String page){
        if(pageNow.equals(home) || pageNow.equals(index) || pageNow.equals(online)){
            return page.equals("index");
        }else{
            String pageN = pageNow.replace(".jsp", "");
            return page.equals(pageN);
        }
    }
    
    public static StringBuffer htmlRoutes(List<String> routes, String url, String item, String special){
        StringBuffer links = new StringBuffer();
        for (String route : routes) {
            String link = transformRoutes(url, route);
            String title = toCapitalize(route);
            String clase = "";
            if(special.equals("active")){
                if(activeLink(url, route)){
                    clase = "active";
                }else{
                    clase = "";
                }
            }else if(special.equals("color")){
                if(route.equals("login")){
                    clase = "info";
                }else{
                    clase = "secondary";
                }
            }
            links.append(String.format(item,clase, link, title));
        }
        return links;
    }
}
