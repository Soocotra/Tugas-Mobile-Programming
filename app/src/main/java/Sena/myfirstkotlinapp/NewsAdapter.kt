package Sena.myfirstkotlinapp

import Sena.myfirstkotlinapp.databinding.ListviewContentBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class NewsAdapter(context: Context?, private val arrayList : ArrayList<NewsData>) :
    ArrayAdapter<NewsData>(context!!, R.layout.listview_content, arrayList) {


        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View{

            val inflater: LayoutInflater = LayoutInflater.from(context)
            val view: View = inflater.inflate((R.layout.listview_content ), null)

            val imageView: ImageView = view.findViewById(R.id.imageContainer)
            val titleView: TextView = view.findViewById(R.id.title)
            val authorView: TextView = view.findViewById(R.id.author)

            imageView.setImageResource(arrayList[position].image)
            titleView.text = arrayList[position].title
            authorView.text = arrayList[position].author

            return view

        }

}