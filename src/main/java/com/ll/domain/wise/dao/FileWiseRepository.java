package com.ll.domain.wise.dao;

import com.ll.domain.file.entity.Files;
import com.ll.domain.wise.entity.Wise;

import java.util.List;

public class FileWiseRepository implements WiseRepository {
    private static final List<Wise> wises = load();

    @Override
    public Wise create(String author, String word) {
        Long max = this.max();
        Wise wise = new Wise(max, author, word);
        wises.add(wise);

        this.save(Files.DATABASE_PATH);

        return wise;
    }

    @Override
    public List<Wise> findAll() {
        return wises;
    }

    @Override
    public Wise findOne(Long id) {
        Wise wise = null;

        for (Wise w : wises) {
            if (w.getId().equals(id)) {
                wise = new Wise(w.getId(), w.getAuthor(), w.getWord());
            }
        }

        return wise;
    }

    @Override
    public Wise delete(Long id) {
        Wise wise = null;

        for (int i = 0; i < wises.size(); i++) {
            if (id.equals(wises.get(i).getId())) {
                wise = wises.get(i);
                wises.remove(i);
            }
        }

        this.save(Files.DATABASE_PATH);

        return wise;
    }

    @Override
    public Wise update(Long id, String author, String word) {
        Wise wise = null;

        for (Wise value : wises) {
            if (id.equals(value.getId())) {
                value.setAuthor(author);
                value.setWord(word);
                wise = value;
            }
        }

        this.save(Files.DATABASE_PATH);

        return wise;
    }

    @Override
    public void save(String filePath) {
        Files.buildFile(wises, filePath);
    }

    private static List<Wise> load() {
        return Files.parseFile(Files.DATABASE_PATH);
    }

    private Long max() {
        Long max = 0L;

        for (Wise wise : wises) {
            if (max < wise.getId()) max = wise.getId();
        }

        return max + 1;
    }
}
