package com.ll.domain.wise.entity;

import java.util.List;

public class Wise {
    private Long id;
    private String author;
    private String word;

    public Wise() {
    }

    public Wise(Long id, String author, String word) {
        this.id = id;
        this.author = author;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getWord() {
        return word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Wise> create(List<Wise> wises, String author, String word) {
        Wise wise = new Wise((long) (wises.size() + 1), author, word);
        System.out.println(wise.id + "번 명언이 등록되었습니다.");
        wises.add(wise);

        return wises;
    }

    public void list(List<Wise> wises) {
        wises.forEach(wise -> {
            System.out.print(wise.id);
            System.out.print(" / ");
            System.out.print(wise.author);
            System.out.print(" / ");
            System.out.print(wise.word);
            System.out.println();
        });
    }

    public boolean delete(List<Wise> wises, Long id) {
        boolean isNull = true;

        for (int i = 0; i < wises.size(); i++)
            if (wises.get(i).id == id) {
                wises.remove(i);
                isNull = false;
            }

        return isNull;
    }

    public Wise get(List<Wise> wises, Long id) {
        Wise wise = null;

        for (Wise w : wises) {
            if (w.id == id) {
                wise = new Wise(w.id, w.author, w.word);
            }
        }

        return wise;
    }

    public List<Wise> update(List<Wise> wises, Wise wise, String author, String word, Long id) {
        wise.author = author;
        wise.word = word;

        for (int i = 0; i < wises.size(); i++) {
            if (wises.get(i).id == id) {
                wises.remove(i);
                wises.add(wise);
            }
        }

        System.out.println(id + "번 명언이 수정되었습니다.");

        return wises;
    }
}
