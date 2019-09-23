<?xml version="1.0" encoding="utf-8"?>

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    android:background="@drawable/background2"

    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:context=".MainActivity"
    tools:showIn="@layout/activity_main">


    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="160dp"
        android:orientation="horizontal"
        app:layout_constraintEnd_toStartOf="parent"
        app:layout_constraintHorizontal_bias="0.082"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">


        <!-- RelativeLayout used for centering feature -->

        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <Button
                android:id="@+id/button"
                android:layout_width="110dp"
                android:layout_height="wrap_content"
                android:layout_alignParentEnd="true"
                android:layout_alignParentRight="true"
                android:layout_alignParentBottom="true"
                android:layout_marginEnd="264dp"
                android:layout_marginRight="264dp"
                android:layout_marginBottom="278dp"

                android:text="Convert" />

            <RadioButton
                android:id="@+id/fromLiterstoGallons"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentBottom="true"
                android:layout_marginBottom="402dp"
                android:text="Liters to Gallons"
                android:textColor="#effeff" />

            <RadioButton
                android:id="@+id/fromGallonstoLiters"
                android:layout_width="wrap_content"
          