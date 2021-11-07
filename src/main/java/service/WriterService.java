package service;

import model.entity.Writer;
import repository.WriterRepository;

import java.util.List;

/**
 * @author Nikita Gvardeev 01.11.2021
 * email gvardeev@po-korf.ru
 */
public class WriterService {

    private WriterRepository writerRepository;

    public WriterService() {
        writerRepository = new WriterRepository();
    }

    public void create(Writer writer) {
        writerRepository.add(writer);
    }

    public List<Writer> read() {
        return writerRepository.read();
    }

    public void update(Writer writer) {
        writerRepository.update(writer);
    }

    public void delete(Writer writer) {
        writerRepository.remove(writer);
    }
}