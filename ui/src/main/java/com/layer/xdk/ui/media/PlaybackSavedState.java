package com.layer.xdk.ui.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;

/**
 * Container class to add relevant playback details to a Bundle.
 */
public class PlaybackSavedState implements Parcelable {
    /**
     * Duration of the audio
     */
    public int mDuration;

    /**
     * Current playback position
     */
    public int mPlaybackPosition;

    /**
     * Current playback state
     */
    @PlaybackStateCompat.State
    public int mPlaybackState = PlaybackStateCompat.STATE_NONE;
    
    /**
     * Current percent of file that is buffered
     */
    public int mBufferedPercent;

    PlaybackSavedState() {
    }

    private PlaybackSavedState(Parcel in) {
        mDuration = in.readInt();
        mPlaybackPosition = in.readInt();
        mPlaybackState = in.readInt();
        mBufferedPercent = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mDuration);
        dest.writeInt(mPlaybackPosition);
        dest.writeInt(mPlaybackState);
        dest.writeInt(mBufferedPercent);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PlaybackSavedState> CREATOR = new Parcelable.Creator<PlaybackSavedState>() {
        @Override
        public PlaybackSavedState createFromParcel(Parcel in) {
            return new PlaybackSavedState(in);
        }

        @Override
        public PlaybackSavedState[] newArray(int size) {
            return new PlaybackSavedState[size];
        }
    };
}