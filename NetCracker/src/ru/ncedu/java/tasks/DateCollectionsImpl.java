package ru.ncedu.java.tasks;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

/**
 * Created by dimon on 02.09.17.
 */
public class DateCollectionsImpl implements DateCollections {
    private int dateStyle;
    private TreeMap<String, Element> mainMap;

    public DateCollectionsImpl() {
        this.dateStyle = DateFormat.MEDIUM;
    }

    @Override
    public void setDateStyle(int dateStyle) {
        this.dateStyle = dateStyle;
    }

    @Override
    public Calendar toCalendar(String dateString) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateFormat.getDateInstance(this.dateStyle).parse(dateString));
        return calendar;
    }

    @Override
    public String toString(Calendar date) {
        return DateFormat.getDateInstance(this.dateStyle).format(date.getTime());
    }

    @Override
    public void initMainMap(int elementsNumber, Calendar firstDate) {
        this.mainMap = new TreeMap<String, Element>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                int result = 0;
                try {
                    Calendar c1 = toCalendar(s1);
                    Calendar c2 = toCalendar(s2);
                    result = c1.getTime().compareTo(c2.getTime());
                } catch (ParseException e) {
                }
                return result;
            }
        });

        Random getLifetime = new Random();
        DateFormat dateFormat = DateFormat.getDateInstance(this.dateStyle);
        for(int i=0; i<elementsNumber; ++i) {
            Calendar birthDate = (Calendar) firstDate.clone();
            birthDate.add(Calendar.DAY_OF_MONTH, i*110);
            this.mainMap.put(dateFormat.format(birthDate.getTime()),
                    new Element(birthDate, getLifetime.nextInt(2000)));
        }
    }

    @Override
    public void setMainMap(Map<String, Element> mainMap) {
        // DRY is badly violated
        this.mainMap = new TreeMap<String, Element>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                int result = 0;
                try {
                    Calendar c1 = toCalendar(s1);
                    Calendar c2 = toCalendar(s2);
                    result = c1.getTime().compareTo(c2.getTime());
                } catch (ParseException e) {
                }
                return result;
            }
        });
        this.mainMap.putAll(mainMap);
    }

    @Override
    public Map<String, Element> getMainMap() {
        return this.mainMap;
    }

    @Override
    public SortedMap<String, Element> getSortedSubMap() {
        DateFormat dateFormat = DateFormat.getDateInstance(this.dateStyle);
        return this.mainMap.tailMap(dateFormat.format(Calendar.getInstance().getTime()), false);
    }

    @Override
    public List<Element> getMainList() {
        return new ArrayList<Element>(this.mainMap.values());
    }

    @Override
    public void sortList(List<Element> list) {
        Collections.sort(list, new Comparator<Element>() {
            @Override
            public int compare(Element e1, Element e2) {
                return e1.getDeathDate().getTime().compareTo(e2.getDeathDate().getTime());
            }
        });
    }

    @Override
    public void removeFromList(List<Element> list) {
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            Element element = it.next();
            int month = element.getBirthDate().get(Calendar.MONTH);
            if (month == 0 || month == 1 || month == 11) {
                it.remove();
            }
        }
    }
}
