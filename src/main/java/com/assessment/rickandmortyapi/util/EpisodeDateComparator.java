package com.assessment.rickandmortyapi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Locale;
import com.assessment.rickandmortyapi.dto.Episode;

public class EpisodeDateComparator implements Comparator<Episode>
{
    @Override
    public int compare( Episode episode1, Episode episode2 )
    {


        return parseDate(episode1.getAir_date()).compareTo( parseDate( episode2.getAir_date() ) );
    }
    private LocalDate parseDate(final String date){

        final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern( "M d, y", Locale.ENGLISH );
        return LocalDate.parse( date,formatter );
    }
}

