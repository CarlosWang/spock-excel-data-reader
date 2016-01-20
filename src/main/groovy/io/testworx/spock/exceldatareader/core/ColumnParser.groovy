/*
The MIT License (MIT)

Copyright (c) 2015 Nicholas Oppersdorff

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */

package io.testworx.spock.exceldatareader.core

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
/**
 * Created by nvonop on 12/11/2015.
 */
class ColumnParser {

    Sheet dataSheet
    CellParser cellParser

    public ColumnParser(Sheet sheet) {
        dataSheet = sheet
    }

    public ArrayList columnDataToList(int index) {
        cellParser = new CellParser()
        List data = new ArrayList()
        Cell cell

        Iterator rowIterator = dataSheet.rowIterator()
        while (rowIterator.hasNext()) {
            Row row = (Row) rowIterator.next()
            cell = row.getCell(index)
            cellParser.addCellDataToList(cell, data)
        }
        return data
    }
}
