import org.json.simple.*;

public class test_client {
    static {
        String lib_name = "quickmsg_java";
        try {
            System.loadLibrary(lib_name);
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Could not find "+lib_name+". Check Library Search Path");
            System.exit(1);
        }
    }

    public static void main(String[] argv) {
        Client c = new Client("add");
        JSONArray arr = new JSONArray();
        arr.add(1);
        arr.add(85);
        JSONObject jsonreq = new JSONObject();
        jsonreq.put("ints_to_add", arr);
        String json_req_str = JSONObject.toJSONString(jsonreq);
        System.out.println("Client request "+json_req_str);
        String jsonresp = c.call_srv(json_req_str);
        System.out.println("Client response "+jsonresp);
    }
}
