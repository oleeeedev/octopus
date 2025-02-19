package dev.ole.octopus.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.Instant;

public class InstantAdapter extends TypeAdapter<Instant> {
    @Override
    public void write(JsonWriter out, Instant value) throws IOException {
        out.value(value != null ? value.toString() : null);
    }

    @Override
    public Instant read(JsonReader in) throws IOException {
        String dateStr = in.nextString();
        return dateStr != null ? Instant.parse(dateStr) : null;
    }
}