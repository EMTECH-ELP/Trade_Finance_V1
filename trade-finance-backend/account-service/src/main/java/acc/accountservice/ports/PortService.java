package acc.accountservice.ports;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortService {
    private final PortRepository portRepository;

    public PortService(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    public Port addPort(String name, String country) {
        Port port = new Port();
        port.setName(name);
        port.setCountry(country);
        return portRepository.save(port);
    }

    public List<Port> getAllPorts() {
        return null;//will revisit
    }
}
