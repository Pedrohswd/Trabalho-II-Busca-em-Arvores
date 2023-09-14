/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaArvores.SearchResult;

import java.util.Objects;

/**
 *
 * @author pedro
 */
public class SearchResult {

    private int comparisons;
    private int occurrences;
    private String word;
    private boolean search;

    public SearchResult(int comparisons, int occurrences, String word) {
        this.comparisons = comparisons;
        this.occurrences = occurrences;
        this.word = word;
    }

    public SearchResult(int comparisons, int occurrences) {
        this.comparisons = comparisons;
        this.occurrences = occurrences;
    }

    public SearchResult(int comparisons, boolean search) {
        this.comparisons = comparisons;
        this.search = search;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.word);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchResult other = (SearchResult) obj;
        return Objects.equals(this.word, other.word);
    }

}
