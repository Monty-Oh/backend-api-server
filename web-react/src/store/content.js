import {createSelector, createSlice} from "@reduxjs/toolkit";

const content = createSlice(
    {
        name: "content",
        initialState: {
            data: [
                //  Test Data...
                {id: 1, tag: 'tag1', imageSrc: 'logo192.png', order: 1},
                {id: 2, tag: 'tag2', imageSrc: 'logo192.png', order: 2},
                {id: 3, tag: 'tag3', imageSrc: 'logo192.png', order: 3},
                {id: 4, tag: 'tag3', imageSrc: 'logo192.png', order: 4},
                {id: 5, tag: 'tag3', imageSrc: 'logo192.png', order: 5},
            ],
        },
        reducers: {},
        extraReducers: (builder) => {

        }
    }
);

export const selectGroupedData = createSelector(
    [state => state.content.data],
    (data) => {
        const groupedData = {};
        data.forEach((value) => {
            if (groupedData[value.tag]) groupedData[value.tag].push(value);
            else groupedData[value.tag] = [value];
        });
        return groupedData;
    }
)

export default content.reducer;