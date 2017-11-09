package ru.ncedu.java.tasks;

import java.util.*;

/**
 * Created by dimon on 03.09.17.
 */
public class StringFilterImpl implements StringFilter {
    private Set<String> stringSet;

    public StringFilterImpl() {
        this.stringSet = new HashSet<>();
    }

    @Override
    public void add(String s) {
        this.stringSet.add(s == null ? null : s.toLowerCase());
    }

    @Override
    public boolean remove(String s) {
        return this.stringSet.remove(s == null ? null : s.toLowerCase());
    }

    @Override
    public void removeAll() {
        // костыль?
        for(Iterator<String> it = this.stringSet.iterator(); it.hasNext(); ) {
            it.next();
            it.remove();
        }
    }

    @Override
    public Collection<String> getCollection() {
        return this.stringSet;
    }

    private interface Filter {
        boolean isOkay(String s);
    }

    private Iterator<String> getFilteredStringsIterator(Filter filter) {
        List<String> filtered = new ArrayList<>();
        for(String s : stringSet) {
            if (filter.isOkay(s)) {
                filtered.add(s);
            }
        }
        return filtered.iterator();
    }

    @Override
    public Iterator<String> getStringsContaining(final String chars) {
        if (chars == null || chars == "")   return stringSet.iterator();
        return getFilteredStringsIterator(new Filter() {
            @Override
            public boolean isOkay(String s) {
                return s != null && s.contains(chars);
            }
        });
    }

    @Override
    public Iterator<String> getStringsStartingWith(final String begin) {
        if (begin == null || begin == "")   return stringSet.iterator();
        return getFilteredStringsIterator(new Filter() {
            @Override
            public boolean isOkay(String s) {
                return s != null && s.startsWith(begin.toLowerCase());
            }
        });
    }

    @Override
    public Iterator<String> getStringsByPattern(final String pattern) {
        // pattern contains 0-2 wildcards
        if (pattern == null || pattern == "")   return stringSet.iterator();
        return getFilteredStringsIterator(new Filter() {
            @Override
            public boolean isOkay(String s) {
                if (s == null)  return false;
                int firstWildcardPos = pattern.indexOf("*");
                if (firstWildcardPos == -1) {
                    return s == pattern;
                }
                int secondWildcardPos = pattern.lastIndexOf("*");
                if (!s.startsWith(pattern.substring(0, firstWildcardPos)))  return false;
                if (!s.endsWith(pattern.substring(secondWildcardPos+1))) return false;
                if (secondWildcardPos != firstWildcardPos) {
                    if (!s.contains(pattern.substring(firstWildcardPos+1, secondWildcardPos)))   return false;
                }
                return true;
            }
        });
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(final String format) {
        if (format == null || format == "")   return stringSet.iterator();
        return getFilteredStringsIterator(new Filter() {
            @Override
            public boolean isOkay(String s) {
                return s != null && s.replaceAll("\\d", "#").equals(format);
            }
        });
    }
}
