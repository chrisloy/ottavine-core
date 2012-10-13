package com.cloy.ottavino.util;

import java.util.Arrays;

import com.cloy.ottavino.Chord;
import com.cloy.ottavino.Note;

public class ArrayUtil {
	
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
	
	public static int[] concatAll(int[] first, int[]... rest) {
		int totalLength = first.length;
		for (int[] array : rest) {
			totalLength += array.length;
		}
		int[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (int[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}
	
	public static Note[] convertToNotes(Integer...pitches) {
		Note[] notes = new Note[pitches.length];
		for(int i=0; i<notes.length; i++) {
			Integer pitch = pitches[i];
			if(pitch == null)
				notes[i] = null;
			else
				notes[i] = new Note(pitches[i]);
		}
		return notes;
	}
	
	public static int[] getNotes(Chord chord) {
		Note[] notes = chord.getNotes();
		int[] pitches = new int[notes.length];
		for(int i=0; i<notes.length; i++)
			pitches[i] = notes[i].getNoteNumber();
		return pitches;
	}
}
