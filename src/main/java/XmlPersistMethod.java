import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Represents a persist method that uses XML
 *
 * @author Manuel Glenk
 * @version 2023-10-04
 */
public class XmlPersistMethod implements PersistMethod {
    private String filename; // The filename

    /**
     * Creates a new XML persist method
     */
    public XmlPersistMethod(String filename) {
        this.filename = filename;
    }

    /**
     * Persists the TrainerStatistics with the JAXB library
     *
     * @param stats The TrainerStatistics to persist
     */
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

    /**
     * Loads the TrainerStatistics with the JAXB library
     *
     * @return The loaded TrainerStatistics
     */
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
