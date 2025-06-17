const { MongoClient } = require('mongodb');
console.log(1);
var url = "mongodb://localhost:27017";
var client = new MongoClient(url);
console.log(2);
(async ()=>{
    await client.connect();

    const dbo = client.db("xe");
    // 최초 컬렉션 존재 없을 시
    const coll = await dbo.createCollection('documents');
    // 컬렉션이 존재시
    const collection = dbo.collection('documents');
    
    // insert Many
    // const insertResult = await collection.insertMany([{ a: 1 }, { a: 2 }, { a: 3 }]);
    
    // insert One
    const insertResult = await collection.insertOne({ a: 2 });
    console.log('Inserted documents =>', insertResult);
    // update One
    const updateResult = await collection.updateOne({ a: 3 }, { $set: { b: 3 } });
    console.log('Updated documents =>', updateResult);
    // select One
    const findResult = await collection.find({a:3}).toArray();
    console.log('Found documents =>', findResult);
    // delete One
    const deleteResult = await collection.deleteMany({ a: 2 });
    console.log('Deleted documents =>', deleteResult);

    // select all
    const findAllResult = await collection.find({}).toArray();
    console.log('Found documents =>', findAllResult);

    client.close();
})();

