package com.clown.roflanmovies.json

import org.json.JSONObject

interface JSONReader<T> {
    /**
     * Загрузка JSON страницы. Вернет её
     * */
    fun download(): String?
    /**
     * Парсинг JSON страницы
     * */
    fun parse(data: String?): MutableList<T>
    /**
     * Парсинг JSON объекта
     * */
    fun parseObject(jsonObject: JSONObject): T?
}