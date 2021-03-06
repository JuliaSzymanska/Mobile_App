package tech.szymanskazdrzalik.module.dao;

import java.io.Serializable;

import tech.szymanskazdrzalik.module.Board;

public class SaveGame implements Serializable {
    private Board board;
    private Integer highScore;
    private Long time;

    public SaveGame(Board board, Integer highScore, Long time) {
        this.board = new Board(board);
        this.highScore = highScore;
        this.time = time;
    }

    public Board getBoard() {
        return board;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public Long getTime() {
        return time;
    }

    public static class SaveGameException extends Exception {
        public SaveGameException(Exception e) {
            super(e);
        }

        public SaveGameException(String s) {
            super(s);
        }

        public SaveGameException(String s, Exception e) {
            super(s, e);
        }
    }
}

