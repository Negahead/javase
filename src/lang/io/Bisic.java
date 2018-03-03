package lang.io;

/**
 *  Java IO and NIO:
 *      IO is stream oriented where NIO is buffer oriented,Java IO being streaming oriented means that you read one or
 *      more bytes at a time,they are not cached anywhere,and you cannot move forth and back in a stream,if you need to
 *      move forth and back in the data read from a stream,you will need to cache it in a buffer first.
 *
 *          In an IO design you read the data byte for byte from an InputStream or a Reader,Imagine you were processing
 *          a stream of line based textual data,for instance:
 *              name: Anna
 *              age: 25
 *              email: anna@gmail.com
 *              phone: 1234567890
 *          this stream of text lines could be processed like this:
 *              InputStream input = ...;
 *              BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 *              String nameLine = reader.readLine();
 *              String ageLine = reader.readLine();
 *              String emailLine = reader.readLine();
 *              String phoneLine = reader.readLine();
 *           Once the first reader.readLine() methods returns.you know for sure that a full line of text has been read,
 *           because the readLine() blocks until a full line is read.And once the executing thread have progressed past
 *           reading a certain piece of data in the code,the thread is not going backwards in the data.
 *
 *      Java NIO is buffer oriented approach is different,Data is read into a buffer from which it is later processed,
 *      you can move forth and back in the buffers as you need to,this gives you a bit more flexibility during processing,
 *      however,you also need to check if the buffer contains all the data you need in order to fully process it,and also
 *      you need to make sure that when reading more data into the buffer,you do not overwrite data in the buffer you
 *      have not yet processed.
 *          A NIO implementation:
 *              ByteBuffer buffer = ByteBuffer.allocate(48);
 *              int bytesRead = inChannel.read(buffer);
 *          the second line which reads bytes from the channel into the ByteBuffer,when that method call returns you don't
 *          know if all the data you need is inside the buffer.All you know is that the buffer contains some bytes.
 *          how do you know if the buffer contains enough data for it to make sense to be processed? Well,you don't.
 *          you have to inspect the data in the buffer several times before you know if all the data is in there.
 *          if the buffer is full,it can be processed,if not full,you might have to partially process whatever data is there.
 *
 *          NIO allows you to manage multiple channels using only a single thread,but the cost is that parsing the data might be
 *          somewhat more complicated that when reading data from a blocking stream.
 *
 *          If you need to manage thousands of open connections simultanously,which each only send a little data,for instance
 *          a chat server,implementing the server in NIO is probably an advantage.
 *
 *          If you have fewer connections with very high bandwidth,sending a lot of data at a time,perhaps a classic IO server
 *          implementation might be the best fit.
 *
 *      Java IO's various stream are blocking,that means when a thread invokes a read or write(),that thread is blocked
 *      util there is some data to read,or the data is fully written,the thread can do nothing else in the mean time.
 *
 *      Java NIO's non-blocking mode enables a thread to request reading data from a channel,and only get what is currently
 *      available,or nothing at all,if no data is currently available,Rather than remain blocked until data becomes available
 *      for reading,the thread can go on with something else.
 *
 *      what threads spend their idle time on when not blocked in IO calls,is usually performing NIO on other channel in the
 *      meantime,that is,a single thread can now manage multiple channels of input and output.
 *
 *      Java NIO's selector allows a single thread to monitor multiple channels of input,you can register multiple channels
 *      with a selector,then use a single thread to 'select' the channels that have input available for processing,or select
 *      the channels that are ready for writing,this selector mechanism makes it easy for a single thread to manage multiple
 *      channels.
 *
 */
public class Bisic {
}
