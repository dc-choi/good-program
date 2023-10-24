package com.ll;

import java.util.List;
import java.util.Optional;

public class Goods {
    Long id;
    String author;
    String word;

    public Goods() {
    }

    public Goods(Long id, String author, String word) {
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

    public static List<Goods> insert(List<Goods> goods, String author, String word) {
        Goods g = new Goods((long) (goods.size() + 1), author, word);
        System.out.println(g.id + "번 명언이 등록되었습니다.");
        goods.add(g);

        return goods;
    }

    public static void list(List<Goods> goods) {
        for (Goods gg : goods) {
            System.out.print(gg.id);
            System.out.print(" / ");
            System.out.print(gg.author);
            System.out.print(" / ");
            System.out.print(gg.word);
            System.out.println();
        }
    }

    public static List<Goods> delete(List<Goods> goods, Long id) {
        boolean isNull = true;

        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).id == id) {
                goods.remove(i);
                isNull = false;
            }
        }

        if (isNull) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        } else {
            System.out.println(id + "번 명언이 삭제되었습니다.");
        }

        return goods;
    }

    public static Goods validation(List<Goods> goods, Long id) {
        Goods g = null;

        for (Goods good : goods) {
            if (good.id == id) {
                g = new Goods(good.id, good.author, good.word);
            }
        }

        if (g == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }

        return g;
    }

    public static List<Goods> update(List<Goods> goods, Goods g, String author, String word, Long id) {
        g.author = author;
        g.word = word;

        for (int i = 0; i < goods.size(); i++) {
            if (goods.get(i).id == id) {
                goods.remove(i);
                goods.add(g);
            }
        }

        System.out.println(id + "번 명언이 수정되었습니다.");

        return goods;
    }
}
