package megafon.internship.controllers.rest;

import megafon.internship.dao.InternDAO;
import megafon.internship.services.InternsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InternAPI {

    @Autowired
    private InternsService internsService;

    @RequestMapping(value = "/interns", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<InternDAO> interns() {
        return internsService.getAllInternsDAO();
    }


    @RequestMapping(value = "/interns/{internId}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> deleteIntern(@PathVariable String internId) {
        internsService.deleteIntern(Long.parseLong(internId));
        Map<String, String> responseMessage = new HashMap<>();
        responseMessage.put("message", "user with id:" + internId + " is deleted");
        return responseMessage;
    }

}
