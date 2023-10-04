import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlPersistMethod implements PersistMethod {
    private String filename;

    public XmlPersistMethod(String filename) {
        this.filename = filename;
    }

    public void persist(TrainerStatistics stats) {
        try {
            JAXBContext context = JAXBContext.newInstance(TrainerStatistics.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(stats, new File(this.filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public TrainerStatistics load() {
        File file = new File(this.filename);

        if (!file.exists()) {
            return new TrainerStatistics();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(TrainerStatistics.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (TrainerStatistics) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
            return new TrainerStatistics();
        }
    }
}
