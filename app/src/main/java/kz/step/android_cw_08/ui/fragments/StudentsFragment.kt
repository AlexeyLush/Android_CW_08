package kz.step.android_cw_08.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kz.step.android_cw_08.HostActivity
import kz.step.android_cw_08.R
import kz.step.android_cw_08.ui.data.Student

class StudentsFragment: Fragment(){

    lateinit var rootView: View
    var studentsList: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_students, container, false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
    }

    fun initializeViews(){
        studentsList = rootView.findViewById<ListView>(R.id.listView_student)
        var student1: Student = Student("Иван","Иванов")
        var student2: Student = Student("Андрей","Андреев")
        var student3: Student = Student("Пётр","Петров")

        val namesList = arrayOfNulls<String>(3)
        namesList[0] = "${student1.lastName} ${student1.firstName}"
        namesList[1] = "${student2.lastName} ${student2.firstName}"
        namesList[2] = "${student3.lastName} ${student3.firstName}"


        var adapter = ArrayAdapter<String>(activity!!.applicationContext,R.layout.fragment_students, namesList)
        studentsList?.adapter = adapter
    }

}