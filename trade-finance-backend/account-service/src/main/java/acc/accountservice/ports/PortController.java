package acc.accountservice.ports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class PortController { private final PortService portService;

    @Autowired
    public PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping("/ports")
    public List<Port> getAllPorts() {
        return portService.getAllPorts();
    }

}
